import { Link } from "react-router-dom";

const MenuSuperior = () => {
  return (
    <nav className="navbar navbar-expand-sm bg-primary navbar-dark sticky-top">
      <div className="container">
        <Link to="/" className="navbar-brand">Controle de Tarefas</Link>
        <ul className="navbar-nav">
          
          
          
          <li className="nav-item">
            <Link to="/usuario" className="nav-link">Cadastrar Usuário</Link>
          </li>

          <li className="nav-item">
            <Link to="/prestadores" className="nav-link">Cadastrar Prestador</Link>
          </li>

          <li className="nav-item">
            <Link to="/endereco" className="nav-link">Cadastrar Endereço</Link>
          </li>

          <li className="nav-item">
            <Link to="/telefone" className="nav-link">Cadastrar Telefone</Link>
          </li>

          <li className="nav-item">
            <Link to="/categoria" className="nav-link">Cadastrar Categoria</Link>
          </li>

          
          
        </ul>
      </div>
    </nav>
  );
};

export default MenuSuperior;