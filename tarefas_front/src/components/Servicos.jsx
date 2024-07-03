import { useForm } from "react-hook-form";
import React, { Component } from 'react';
import { api } from "../config_axios";
import { useState } from "react";
import  styles from "./styles/cadastrarPrestador.module.css";


const Servicos = () => {
    const { register, handleSubmit,reset } = useForm();
    const [aviso, setAviso] = useState("");
    const salvar = async (campos) => {
        try {
            const response = await api.post("/servico", campos);
            setAviso(`Serviço cadastrado com sucesso!`);
            reset();
        } catch (error) {
            setAviso("Erro ao cadastrar!");
        }
    };
    return(
    <div>
     <div className="container-fluid bg-dark text-light min-vh-100 d-flex align-items-center">
      <div className="container p-5 bg-light text-dark rounded">
        <h4 className="fst-italic mb-3">Cadastrar Serviços</h4>
        <div className={styles.div} >
         
        </div>
        <form onSubmit={handleSubmit(salvar)}>
        <div className="form-group mt-2">
            <label htmlFor="servico_nome">Nome:</label>
            <input
              type="text"
              className={styles.form_control}
              id="servico_nome"
              
              {...register("servico_nome")}
            />
          </div>
          <div className="form-group">
            <label htmlFor="servico_descricao">Descrição:</label>
            <input
              type="text"
              className={styles.form_control}
              id="servico_descricao"
              
              autoFocus
              {...register("servico_descricao")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="servico_informacoes_extras">Informacoes extras:</label>
            <input
              type="text"
              className={styles.form_control}
              id="servico_informacoes_extras"
              
              {...register("servico_informacoes_extras")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="servico_preco">Preço:</label>
            <input
              type="number"
              className={styles.form_control}
              id="servico_preco"
              
              {...register("servico_preco")}
            />
          </div>
          <div className="form-group mt-2">
            <label htmlFor="servico_categoria_id">Identificador de categorias:</label>
            <input
              type="number"
              className={styles.form_control}
              id="servico_categoria_id"
              
              {...register("servico_categoria_id")}
            />
            </div>
          

          <div className="form-group mt-2">
            <label htmlFor="servico_prestador_id">Identificador de Prestadores:</label>
            <input
              type="number"
              className={styles.form_control}
              id="servico_prestador_id"
              
              {...register("servico_prestador_id")}
            />
          </div>

          <input
            type="submit"
            className="btn btn-primary mt-3"
            value="Enviar"
          />
          <input
            type="reset"
            className="btn btn-danger mt-3 ms-3"
            value="Limpar"
          />
            </form>
            <div className="alert mt-3">{aviso}</div>
        </div>
    </div>
</div>
  

    
   )
}

export default Servicos