import { useForm } from "react-hook-form";
import { api } from "../config_axios";
import { useState, useEffect } from "react";
import styles from "./styles/cadastrarPrestador.module.css";

const Agendamentos = () => {
  const { register, handleSubmit, reset } = useForm();
  const [aviso, setAviso] = useState("");
  const [servicos, setServicos] = useState([]);
  const [prestadores, setPrestadores] = useState([]);
  const [selectedServicoNome, setSelectedServicoNome] = useState("");

  useEffect(() => {
    const fetchServicos = async () => {
      try {
        const response = await api.get("/servicos");
        setServicos(response.data); // Espera que response.data seja um array de serviços
      } catch (error) {
        console.error("Erro ao buscar serviços", error);
        setServicos([]); // Define servicos como um array vazio em caso de erro
      }
    };

    fetchServicos();
  }, []);

  

  const buscarPrestadoresPorNomeServico = async (servicoNome) => {
    if (!servicoNome) return;

    try {
      const response = await api.get(`/prestador/search?servicoNome=${servicoNome}`);
      setPrestadores(response.data);
      console.log(response.data);
    } catch (error) {
      console.error("Erro ao buscar prestadores por nome do serviço", error);
    }
  };

  const handleServicoChange = (event) => {
    const servicoEncontrado = servicos.find(servico => servico.servico_id === parseInt(event.target.value, 10));
    const servicoNome = servicoEncontrado?.servico_nome;
    setSelectedServicoNome(servicoNome);
    buscarPrestadoresPorNomeServico(servicoNome);
  };

  const salvar = async (campos) => {
    try {
      const response = await api.post("/agendamento", campos);
      setAviso(`Agendamento cadastrado com sucesso!`);
      reset();
    } catch (error) {
      setAviso("Erro ao cadastrar agendamento!");
    }
  };

  return (
    <div className="container-fluid bg-dark text-light min-vh-100 d-flex align-items-center">
      <div className="container p-5 bg-light text-dark rounded">
        <h4 className="fst-italic mb-3">Agendamentos</h4>
        <form onSubmit={handleSubmit(salvar)}>
          <div className="form-group">
            <label htmlFor="agendamento_data">Data:</label>
            <input
              type="date"
              className={styles.form_control}
              id="agendamento_data"
              required
              {...register("agendamento_data")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="agendamento_hora">Hora:</label>
            <input
              type="time"
              className={styles.form_control}
              id="agendamento_hora"
              required
              {...register("agendamento_hora")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="agendamento_observacao">Observação:</label>
            <input
              type="text"
              className={styles.form_control}
              id="agendamento_observacao"
              required
              {...register("agendamento_observacao")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="agendamento_status">Status:</label>
            <input
              type="text"
              className={styles.form_control}
              id="agendamento_status"
              required
              {...register("agendamento_status")}
            />
          </div>

          <div className="form-group mt-2">
            <label htmlFor="servico_id">Serviço:</label>
            <select
              className="form-select"
              id="servico_id"
              {...register("servico_id")}
              defaultValue=""
              onChange={handleServicoChange}
            >
              <option value="" disabled>Selecione um serviço</option>
              {servicos.map(servico => (
                <option key={servico.servico_id} value={servico.servico_id}>{servico.servico_nome}</option>
              ))}
            </select>
          </div>

          <div className="form-group mt-2">
            <label htmlFor="prestador_id">Prestador:</label>
            <select
              className="form-select"
              id="prestador_id"
              {...register("prestador_id")}
              defaultValue=""
              disabled={!selectedServicoNome}
            >
              <option value="" disabled>Selecione um prestador</option>
              {prestadores.map(prestador => (
                <option key={prestador.prestador_id} value={prestador.prestador_id}>{prestador.prestador_nome}</option>
              ))}
            </select>
          </div>

          <input type="submit" className="btn btn-primary mt-3" value="Enviar" />
          <input type="reset" className="btn btn-danger mt-3 ms-3" value="Limpar" />
        </form>
        <div className="alert mt-3">{aviso}</div>
      </div>
    </div>
  );
};

export default Agendamentos;
