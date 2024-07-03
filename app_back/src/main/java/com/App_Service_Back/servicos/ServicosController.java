package com.App_Service_Back.servicos;

import com.App_Service_Back.prestador.PrestadorDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController //habilitar o REST
@RequestMapping("/servicos") // localhost:8080/servicos
public class ServicosController {
    @Autowired
    private ServicosService servicosService;
    @GetMapping //retorna uma lista de servicos
    public ResponseEntity<List<ServicosDTO>> getAllServicos(){
        List<ServicosDTO> servicosDTO = servicosService.findAll();
        System.out.println("servicosDTO"+servicosDTO);
        return ResponseEntity.ok(servicosDTO);
    }
    @GetMapping("/{id}") //localhost:8080/servicos/1 pegar por id
    public ResponseEntity<ServicosDTO> getServicosById(@PathVariable Long id){
        ServicosDTO servicosDTO = servicosService.findById(id);
        return ResponseEntity.ok(servicosDTO);
    }
    @PostMapping //salvar um servico no banco de dados
    public ResponseEntity<ServicosDTO> createServicos(@Valid @RequestBody ServicosDTO servicosDTO){
        ServicosDTO createServicosDTO = servicosService.create(servicosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createServicosDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ServicosDTO> updateServicos(@PathVariable Long id, @Valid @RequestBody ServicosDTO servicosDTO){
        ServicosDTO updateServicosDTO = servicosService.update(id, servicosDTO);
        return ResponseEntity.ok(updateServicosDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicos(@PathVariable Long id){
        servicosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Optional method to expose prestadores by service ID (consider security implications)
//    @GetMapping("/{servicoId}/prestadores")
//    public ResponseEntity<List<PrestadorDTO>> getPrestadoresByServicoId(@PathVariable Long servicoId) {
//        List<PrestadorDTO> prestadores = servicosService.getPrestadoresByServicoId(servicoId);
//        return ResponseEntity.ok(prestadores);
//    }
}
