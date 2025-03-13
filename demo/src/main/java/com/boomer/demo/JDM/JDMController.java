package com.boomer.demo.JDM;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.mindrot.jbcrypt.BCrypt;


@RestController
@RequestMapping("/jdm")
public class JDMController {

    @Autowired
    private JDMRepository jdmRepository;

@PostMapping("/jdmnovo")
private ResponseEntity JDMModel(@RequestBody JDMModel jdmModel, HttpServletRequest request){
    var existente = this.jdmRepository.findByModelo(jdmModel.getModelo());

    if (existente != null) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body:"cadastro existente");
        
    } /*else {
        var criado = this.jdmRepository.save(jdmModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
        */
                // 13/03
            else {
            var senhaHash = BCrypt.withDefaults()
                .hashToString(cost:12, userModel.getSenha().toCharArray());
                userModel.setSenha(senhaHash);
                var criado = this.jdmRepository.save(jdmModel);
                return ResponseEntity.status(HttpStatus.CREATED).body(criado)
    }
}

@GetMapping("/mensagem")
private String retornoMensagem(){
    return "Você acessou um link secreto!";
}
// 13/03
@GetMapping("/jdmusers")
public List<UserModel> listarCarros() {
    List<UserModel> carrocad = jdmRepository.findAll();
    return carrocad;
}

@PutMapping("/atualiza")
public ResponseEntity atualizaUser(@RequestBody UserModel usermodel){
    var criado = this.jdmRepository.save(userModel);
    return Responseentity.status(HttpStatus.CREATED).body(criado);
}

@DeleteMapping("/deletauser/{id}")
public void deletaUser(@PathVariable UUID id){
    jdmRepository.deleteById(id);
}
}