package com.App_Service_Back.endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private EnderecoMapper enderecoMapper;

    //buscando todos os enderecos
    public List<EnderecoDTO> findAll(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos.stream().map(enderecoMapper::toDTO).collect(Collectors.toList());
    }
    // buscar pelo id
    public EnderecoDTO findById(Long id){
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Endereco não encontrado"));
        return enderecoMapper.toDTO(endereco);
    }
    //criando uma nova endereco
    public EnderecoDTO create(EnderecoDTO enderecoDTO){
        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDTO(endereco);
    }
    //update endereco
    public EnderecoDTO update(Long id, EnderecoDTO enderecoDTO) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Endereco não encontrado"));
        enderecoDTO.setEndereco_id(id);
        endereco = enderecoMapper.updateEntity(enderecoDTO, endereco);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDTO(endereco);
    }
    public void deleteById(Long id){
        enderecoRepository.deleteById(id);
    }
}
