//package com.App_Service_Back.cliente;
//
//import com.App_Service_Back.security.JwtTokenService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//@CrossOrigin(origins = "http://localhost:5173")
//@RestController
//@RequestMapping("/login")
//public class LoginController {
//    @Autowired
//    private ClienteRepository clienteRepository;
//
//    @Autowired
//    private JwtTokenService jwtTokenService;
//
//    @PostMapping
//    public ResponseEntity<Map<String, String>> login(@RequestBody Cliente loginCredentials) {
//        Optional<Cliente> user = clienteRepository.findByEmail(loginCredentials.getEmail());
//        if (user.isEmpty() || !user.get().getCliente_senha().equals(loginCredentials.getCliente_senha())) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        String token = jwtTokenService.generateToken(user.get().getEmail());
//        Map<String, String> response = new HashMap<>();
//        response.put("token", token);
//        return ResponseEntity.ok(response);
//    }
//}