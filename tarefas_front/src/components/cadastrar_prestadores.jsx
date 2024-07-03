import React, { useState, useEffect } from 'react';
import { useForm } from 'react-hook-form';
import { api } from '../config_axios';
import styles from './styles/cadastrarPrestador.module.css';

const CadastrarPrestadores = () => {
  const { register, handleSubmit, reset } = useForm();
  const [aviso, setAviso] = useState('');
  const [endereco, setEndereco] = useState([])

  const salvar = async (campos) => {
    try {
      const response = await api.post('prestador', {
        prestador_nome: campos.prestador_nome,
        prestador_cnpj: campos.prestador_cnpj,
        prestador_cpf: campos.prestador_cpf,
        prestador_razaoSocial: campos.prestador_razaoSocial,
        prestador_email: campos.prestador_email,
        prestador_senha: campos.prestador_senha,
        prestador_endereco_id: campos.prestador_endereco_id // Certifique-se de que o campo está sendo enviado corretamente
      });

      // Limpar o formulário após o envio bem-sucedido
      reset();

      // Exibir uma mensagem de sucesso ou fazer outra ação necessária
      setAviso('Prestador cadastrado com sucesso!');
    } catch (error) {
      // Tratar erros de requisição
      console.error('Erro ao cadastrar prestador:', error);
      setAviso('Erro ao cadastrar prestador. Por favor, tente novamente.');
    }
  };

  useEffect(() => {
    const fetchEndereco = async () => {
      try {
        const response = await api.get("/endereco");
        setEndereco(response.data || []); // Ajustado para garantir que seja um array
        console.log(response.data);
      } catch (error) {
        console.error("Erro ao buscar concessionárias:", error);
        setEndereco([]); // Garantir que seja sempre um array
      }
    };
    fetchEndereco();
  }, []);

  return (
    <div className="container-fluid bg-dark text-light min-vh-100 d-flex align-items-center">
      <div className="container p-5 bg-light text-dark rounded">
        <h4 className="fst-italic mb-3">Cadastrar Prestador</h4>
        <form onSubmit={handleSubmit(salvar)}>
          <div className="form-group">
            <label htmlFor="prestador_cnpj">CNPJ:</label>
            <input
              type="text"
              className={styles.form_control}
              id="prestador_cnpj"
              {...register('prestador_cnpj')}
              autoFocus
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="prestador_cpf">CPF:</label>
            <input
              type="number"
              className={styles.form_control}
              id="prestador_cpf"
              {...register('prestador_cpf')}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="prestador_email">Email:</label>
            <input
              type="email"
              className={styles.form_control}
              id="prestador_email"
              {...register('prestador_email')}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="prestador_nome">Nome:</label>
            <input
              type="text"
              className={styles.form_control}
              id="prestador_nome"
              {...register('prestador_nome')}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="prestador_razao_social">Razão Social:</label>
            <input
              type="text"
              className={styles.form_control}
              id="prestador_razao_social"
              {...register('prestador_razao_social')}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="prestador_senha">Senha:</label>
            <input
              type="password"
              className={styles.form_control}
              id="prestador_senha"
              {...register('prestador_senha')}
            />
          </div>
          {endereco.length > 0 && (
            <div className="form-group mt-2">
              <label htmlFor="endereco_id">endereço:</label>
              <select
                className="form-control"
                id="endereco_id"
                required
                {...register("endereco_id")}
              >
                <option value="" selected disabled>
                  Selecione uma endereço
                </option>
                {endereco.map((enderecos) => (
                  <option
                    key={enderecos.endereco_id}
                    value={enderecos.endereco_id}
                  >
                    {enderecos.cidade}
                  </option>
                ))}
              </select>
            </div>
          )}

          <input type="submit" className="btn btn-primary mt-3" value="Enviar" />
          <input type="reset" className="btn btn-danger mt-3 ms-3" value="Limpar" />
        </form>

        <div className={`alert mt-3 ${aviso ? 'alert-success' : 'alert-danger'}`}>{aviso}</div>
      </div>
    </div>
  );
};

export default CadastrarPrestadores;
