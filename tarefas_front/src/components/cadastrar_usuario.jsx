import React, { useState } from 'react';
import { useForm } from 'react-hook-form';
import { api } from '../config_axios';
import styles from './styles/cadastrarPrestador.module.css';

const CadastrarUsuario = () => {
  const { register, handleSubmit, reset } = useForm();
  const [aviso, setAviso] = useState('');

  const salvar = async (campos) => {
    try {
      const response = await api.post('cliente', {
        cliente_nome: campos.cliente_nome,
        cliente_cpf: campos.usuario_cpf,
        email: campos.usuario_email,
        cliente_dataNascimento: campos.usuario_data_nascimento,
        cliente_senha: campos.usuario_senha,
        cliente_endereco_id: campos.usuario_endereco_id
      });

      // Limpar o formulário após o envio bem-sucedido
      reset();

      // Exibir uma mensagem de sucesso ou fazer outra ação necessária
      setAviso('Usuário cadastrado com sucesso!');
    } catch (error) {
      // Tratar erros de requisição
      console.error('Erro ao cadastrar usuário:', error);
      setAviso('Erro ao cadastrar usuário. Por favor, tente novamente.');
    }
  };

  return (
    <div className="container-fluid bg-dark text-light min-vh-100 d-flex align-items-center">
      <div className="container p-5 bg-light text-dark rounded">
        <h4 className="fst-italic mb-3">Cadastrar Usuário</h4>
        <form onSubmit={handleSubmit(salvar)}>
          <div className="form-group mt-2">
            <label htmlFor="usuario_cpf">CPF:</label>
            <input
              type="text"
              className={styles.form_control}
              id="usuario_cpf"
              {...register('usuario_cpf', { required: true })}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="usuario_data_nascimento">Data de Nascimento:</label>
            <input
              type="date"
              className={styles.form_control}
              id="usuario_data_nascimento"
              {...register('usuario_data_nascimento', { required: true })}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="usuario_email">Email:</label>
            <input
              type="email"
              className={styles.form_control}
              id="usuario_email"
              {...register('usuario_email', { required: true })}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="usuario_senha">Senha:</label>
            <input
              type="password"
              className={styles.form_control}
              id="usuario_senha"
              {...register('usuario_senha', { required: true })}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="usuario_endereco_id">ID de Endereço:</label>
            <input
              type="number"
              className={styles.form_control}
              id="usuario_endereco_id"
              {...register('usuario_endereco_id', { required: true })}
            />
          </div>

          <input type="submit" className="btn btn-primary mt-3" value="Enviar" />
          <input type="reset" className="btn btn-danger mt-3 ms-3" value="Limpar" />
        </form>

        <div className={`alert mt-3 ${aviso ? 'alert-success' : 'alert-danger'}`}>{aviso}</div>
      </div>
    </div>
  );
};

export default CadastrarUsuario;
