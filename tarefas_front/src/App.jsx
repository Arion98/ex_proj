
import Menu_Superior from './components/MenuSuperior';
import Manutencao_Tarefas from './components/manutencao_tarefas';
import FormularioLogin from './components/login';
import Cadastrar_Usuarios from './components/cadastrar_usuario';
import Cadastrar_endereco from './components/Cadastrar_endereco';
import Cadastrar_prestadores from './components/cadastrar_prestadores';
import Agendamentos from './components/agendamentos';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import { AuthProvider, useAuth } from './components/AuthProvider';
import Cadastrar_categoria from './components/Cadastrar_categoria';
import Cadastrar_telefone from './components/Cadastrar_telefone';
import Servicos from './components/Servicos';

const ProtectedRoute = ({ children }) => {
  const { autenticado } = useAuth();
  const navigate = useNavigate(); // Utilize useNavigate for programmatic navigation

  if (!autenticado) {
    navigate('/login'); // Redirect to login on unauthorized access
    return null;
  }

  return children;
};

const RoutesWithAuth = () => {
  const { autenticado } = useAuth();

  return (
    <Router>
            {autenticado && <Menu_Superior />}
            <Routes>
                <Route path="/login" element={<FormularioLogin />} />
                <Route path="/" element={autenticado ? <Navigate to="/tarefas" /> : <FormularioLogin />} />
                <Route path="/prestadores" element={
                    
                        <Cadastrar_prestadores />
                    
                } />
                <Route path="/user" element={
                    <ProtectedRoute>
                        <Cadastrar_Usuarios />
                    </ProtectedRoute>
                } />
                <Route path="/agendamento" element={
                  
                        <Agendamentos />
                    
                } />
            </Routes>
        </Router>
  );
};

const App = () => {
  return (
    <AuthProvider>
      <RoutesWithAuth />
    </AuthProvider>
  );
};

export default App;