package com.App_Service_Back.prestador;

import com.App_Service_Back.servicos.Servicos;
import com.App_Service_Back.servicos.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestadorService {
    @Autowired
    private PrestadorRepository prestadorRepository;
    @Autowired
    private PrestadorMapper prestadorMapper;
    @Autowired
    private ServicosRepository servicosRepository;

    //buscando todos os prestadores
    public List<PrestadorDTO> findAll(){
        List<Prestadores> prestadores = prestadorRepository.findAll();
        return prestadores.stream().map(prestadorMapper::toDTO).collect(Collectors.toList());
    }

    // buscar pelo id
    public PrestadorDTO findById(Long id){
        Prestadores prestador = prestadorRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Prestador não encontrado"));
        return prestadorMapper.toDTO(prestador);
    }

    //criando um novo prestador
    public PrestadorDTO create(PrestadorDTO prestadorDTO){
        Prestadores prestador = prestadorMapper.toEntity(prestadorDTO);
        prestador = prestadorRepository.save(prestador);
        return prestadorMapper.toDTO(prestador);
    }

    //update prestador
    public PrestadorDTO update(Long id, PrestadorDTO prestadorDTO) {
        Prestadores prestador = prestadorRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Prestador não encontrado"));
        prestadorDTO.setPrestador_id(id);
        prestador = prestadorMapper.updateEntity(prestadorDTO, prestador);
        prestador = prestadorRepository.save(prestador);
        return prestadorMapper.toDTO(prestador);
    }

    public void deleteById(Long id){
        prestadorRepository.deleteById(id);
    }

    public List<PrestadorDTO> findByServicoNome(String servicoNome) {
        List<Servicos> servicos = servicosRepository.findByServicoNome(servicoNome);
        List<Prestadores> prestadores = servicos.stream()
                .map(Servicos::getPrestadores)
                .collect(Collectors.toList());
        return prestadores.stream().map(prestadorMapper::toDTO).collect(Collectors.toList());
    }
}