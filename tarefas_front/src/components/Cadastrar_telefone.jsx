import { useForm } from "react-hook-form";
import { api } from "../config_axios";
import { useState } from "react";
import  styles from "./styles/cadastrarPrestador.module.css";

const Cadastrar_telefone= () => {
  const { register, handleSubmit, reset} = useForm();
  const [aviso, setAviso] = useState("");

  const salvar = async (campos) => {
    try {
      const response = await api.post("/telefone", campos);
      setAviso(`telefone cadastrado com sucesso!`);
      reset();
    } catch (error) {
      setAviso("Erro ao cadastrar telefone!");
    }
  };

  return (
    <div className="container-fluid bg-dark text-light min-vh-100 d-flex align-items-center">
      <div className="container p-5 bg-light text-dark rounded">
        <h4 className="fst-italic mb-3">Cadastrar telefone</h4>
        <form onSubmit={handleSubmit(salvar)}>
          <div className="form-group">
            <label htmlFor="telefone_numero">numero:</label>
            <input
              type="number"
             className={styles.form_control}
              id="telefone_numero"
              required
              {...register("telefone_numero")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="telefone_prestador_id">Identificador de prestador:</label>
            <input
              type="text"
             className={styles.form_control}
              id="telefone_prestador_id"
              required
              {...register("telefone_prestador_id")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="telefone_usuario_id">Identificador de usuário:</label>
            <input
              type="text"
             className={styles.form_control}
              id="telefone_usuario_id"
              required
              {...register("telefone_usuario_id")}
            />
          </div>
    
          <input type="submit" className="btn btn-primary mt-3" value="Enviar" />
          <input type="reset" className="btn btn-danger mt-3 ms-3" value="Limpar" />
        </form>
        <div className="alert mt-3">{aviso}</div>
      </div>
    </div>
  );
};

export default Cadastrar_telefone;
