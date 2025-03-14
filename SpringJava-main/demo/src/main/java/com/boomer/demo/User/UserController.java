package com.boomer.demo.User;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


@PostMapping("/novo")
private UserModel criar(@RequestBody UserModel userModel, HttpServletRequest request){
    System.out.println("System");
    var criado = this.userRepository.save(userModel);
    return criado;

}

@GetMapping("/i")
private String msg(){
    return "Você acessou um link secreto!";
}
}