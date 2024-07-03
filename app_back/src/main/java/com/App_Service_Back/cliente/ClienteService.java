package com.App_Service_Back.cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    //criando um novo cliente
//    public ClienteDTO create(ClienteDTO clienteDTO) {
//        Cliente cliente = new Cliente();
//        cliente.setCliente_nome(clienteDTO.getCliente_nome());
//        cliente.setCliente_cpf(clienteDTO.getCliente_cpf());
//        cliente.setEmail(clienteDTO.getEmail());
//        cliente.setCliente_senha(passwordEncoder.encode(clienteDTO.getCliente_senha()));
//        cliente.setCliente_dataNascimento(clienteDTO.getCliente_dataNascimento());
//        cliente.setEndereco(clienteDTO.getEndereco());
//
//        cliente = clienteMapper.toEntity(clienteDTO);
//        cliente = clienteRepository.save(cliente);
//
//        return clienteMapper.toDTO(cliente);
//    }
    //buscando todos os clientes
    public List<ClienteDTO> findAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(clienteMapper::toDTO).collect(Collectors.toList());
    }
    // buscar pelo id
    public ClienteDTO findById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Cliente não encontrado"));
        return clienteMapper.toDTO(cliente);
    }
    //criando um novo cliente
    public ClienteDTO create(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        System.out.println("Cliente antes de criptografar a senha: " + cliente);
        System.out.println("Cliente depois de criptografar a senha: " + cliente);
        cliente = clienteRepository.save(cliente);
        System.out.println("Cliente salvo: " + cliente);
        return clienteMapper.toDTO(cliente);
    }
    //update cliente
    public ClienteDTO update(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
        clienteDTO.setCliente_id(id);
        cliente = clienteMapper.updateEntity(clienteDTO, cliente);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDTO(cliente);
    }
    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> findByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
}
