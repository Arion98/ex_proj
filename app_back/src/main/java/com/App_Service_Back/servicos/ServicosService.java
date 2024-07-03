package com.App_Service_Back.servicos;

import com.App_Service_Back.prestador.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicosService {
    @Autowired
    private ServicosRepository servicosRepository;
    @Autowired
    private ServicosMapper servicosMapper;
    @Autowired
    private PrestadorService prestadorService;

    //buscando todos os servicos
    public List<ServicosDTO> findAll(){
        List<Servicos> servicos = servicosRepository.findAll();
        return servicos.stream().map(servicosMapper::toDTO).collect(Collectors.toList());
    }
    // buscar pelo id
    public ServicosDTO findById(Long id){
        Servicos servicos = servicosRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Serviço não encontrado"));
        return servicosMapper.toDTO(servicos);
    }
    //criando um novo serviço
    public ServicosDTO create(ServicosDTO servicosDTO){
        Servicos servicos = servicosMapper.toEntity(servicosDTO);
        servicos = servicosRepository.save(servicos);
        return servicosMapper.toDTO(servicos);
    }
    //update serviços
    public ServicosDTO update(Long id, ServicosDTO servicosDTO) {
        Servicos servicos = servicosRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Serviço não encontrado"));
        servicosDTO.setServico_id(id);
        servicos = servicosMapper.updateEntity(servicosDTO, servicos);
        servicos = servicosRepository.save(servicos);
        return servicosMapper.toDTO(servicos);
    }
    public void deleteById(Long id){
        servicosRepository.deleteById(id);
    }

    // New method to get prestadores by service ID
//    @GetMapping("/{servicoId}/prestadores")
//    public ResponseEntity<List<PrestadorDTO>> getPrestadoresByServicoId(@PathVariable Long servicoId) {
//        Servicos servicos = servicosRepository.findById(servicoId).orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado"));
//        List<PrestadorDTO> prestadores = servicosRepository.findPrestadoresByServico(servicos);
//        return ResponseEntity.ok(prestadores);
//    }

}
