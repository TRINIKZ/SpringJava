package com.boomer.demo.JDM;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/jdm")
public class JDMController {

    @Autowired
    private JDMRepository jdmRepository;

@PostMapping("/jdmnovo")
public ResponseEntity<Object> createJDM(@RequestBody JDMModel jdmModel, HttpServletRequest request) {
    var existente = this.jdmRepository.findByModelo(jdmModel.getModelo());

    if (existente != null) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("cadastro existente");
    } else {
        var senhaHash = BCrypt.withDefaults()
            .hashToString(12, jdmModel.getSenha().toCharArray());
        jdmModel.setSenha(senhaHash);
        var criado = this.jdmRepository.save(jdmModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }
}

// 13/03
@GetMapping("/jdmusers")
public List<JDMModel> listarCarros(){
    List<JDMModel> carrocad = jdmRepository.findAll();
    return carrocad;
}

@PutMapping("/atualiza")
public ResponseEntity atualizaUser(@RequestBody JDMModel jdmModel){
    var criado = this.jdmRepository.save(jdmModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(criado);
}

@DeleteMapping("/deletauser/{id}")
public void deletaUser(@PathVariable UUID id){
    jdmRepository.deleteById(id);
}
}