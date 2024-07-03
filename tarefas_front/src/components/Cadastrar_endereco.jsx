import { useForm } from "react-hook-form";
import { api } from "../config_axios";
import { useState } from "react";

const Cadastrar_endereco= () => {
  const { register, handleSubmit, reset} = useForm();
  const [aviso, setAviso] = useState("");

  const salvar = async (campos) => {
    try {
      const response = await api.post("/endereco", campos);
      setAviso(`endereco cadastrado com sucesso!`);
      reset();
    } catch (error) {
      setAviso("Erro ao cadastrar endereco!");
    }
  };

  return (
    <div className="container-fluid bg-dark text-light min-vh-100 d-flex align-items-center">
      <div className="container p-5 bg-light text-dark rounded">
        <h4 className="fst-italic mb-3">Cadastrar endereco</h4>
        <form onSubmit={handleSubmit(salvar)}>
          <div className="form-group">
            <label htmlFor="endereco_bairro">Bairro:</label>
            <input
              type="text"
              className="form-control"
              id="endereco_bairro"
              required
              {...register("endereco_bairro")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="endereco_cep">Cep:</label>
            <input
              type="text"
              className="form-control"
              id="endereco_cep"
              required
              {...register("endereco_cep")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="endereco_cidade">Cidade:</label>
            <input
              type="text"
              className="form-control"
              id="endereco_cidade"
              required
              {...register("endereco_cidade")}
            />
          </div>
          <div className="row mt-2">
            <div className="col-sm-4">
              <div className="form-group">
                <label htmlFor="endereco_complemento">Complemento:</label>
                <input
                  type="text"
                  className="form-control"
                  id="endereco_complemento"
                  required
                  {...register("endereco_complemento")}
                />
              </div>
            </div>
          </div>
          <div className="row mt-2">
            <div className="col-sm-4">
              <div className="form-group">
                <label htmlFor="endereco_estado">Estado:</label>
                <input
                  type="text"
                  className="form-control"
                  id="endereco_estado"
                  required
                  {...register("endereco_estado")}
                />
              </div>
            </div>
          </div>
          <div className="row mt-2">
            <div className="col-sm-4">
              <div className="form-group">
                <label htmlFor="endereco_numero">Numero:</label>
                <input
                  type="number"
                  className="form-control"
                  id="endereco_numero"
                  required
                  {...register("endereco_numero")}
                />
              </div>
            </div>
          </div>
          <div className="row mt-2">
            <div className="col-sm-4">
              <div className="form-group">
                <label htmlFor="endereco_rua">Rua:</label>
                <input
                  type="text"
                  className="form-control"
                  id="endereco_rua"
                  required
                  {...register("endereco_rua")}
                />
              </div>
            </div>
          </div>
          <input type="submit" className="btn btn-primary mt-3" value="Enviar" />
          <input type="reset" className="btn btn-danger mt-3 ms-3" value="Limpar" />
        </form>
        <div className="alert mt-3">{aviso}</div>
      </div>
    </div>
  );
};

export default Cadastrar_endereco;
