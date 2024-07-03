package com.App_Service_Back.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    //buscando todas as categorias
    public List<CategoriaDTO> findAll(){
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map(categoriaMapper::toDTO).collect(Collectors.toList());
    }
    // buscar pelo id
    public CategoriaDTO findById(Long id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Categoria não encontrada"));
        return categoriaMapper.toDTO(categoria);
    }
    //criando uma nova categoria
    public CategoriaDTO create(CategoriaDTO categoriaDTO){
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(categoria);
    }
    //update categoria
    public CategoriaDTO update(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Categoria não encontrada"));
        categoriaDTO.setCategoria_id(id);
        categoria = categoriaMapper.updateEntity(categoriaDTO, categoria);
        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(categoria);
    }

    public void deleteById(Long id){
        categoriaRepository.deleteById(id);
    }
}
