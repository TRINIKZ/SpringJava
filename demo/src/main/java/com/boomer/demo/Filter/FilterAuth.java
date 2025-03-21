package com.boomer.demo.Filter;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.boomer.demo.JDM.JDMRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Base64;

    @Component
    public class FilterAuth extends OncePerRequestFilter {
    @Autowired
    JDMRepository jdmRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var authorization = request.getHeader("Authorizatiton");
        System.out.println("ALREADY_FILTERED_SUFFIX");
        System.out.println(authorization);

        var authEncode = authorization.substring("Basic".length()).trim();
        System.out.println("ALREADY_FILTERED_SUFFIX");
        System.out.println(authEncode);

        byte[] authDecode = Base64.getDecoder().decode(authEncode);
        System.out.println("ALREADY_FILTERED_SUFFIX");
        System.out.println(authDecode);
        
        var authString = new String(authDecode);
        System.out.println(authString);
        String[] credenciais = authString.split(":");
        String username = credenciais[0];
        String senha = credenciais [1];
        System.out.println(username);
        System.out.println(senha);
//Validação de usuario
        var user = this.jdmRepository.findByUsermame(username);
        if (user == null){
            response.sendError(401, "usuario sem autorizacao") ;
        } else{
            var verificaSenha = BCrypt.verifyer().verify(senha.toCharArray(), user.getPassword());
            if(verificaSenha.verified){
                filterChain.doFilter(request, response);
            } else{
                response.sendError(401);
            }
        }
    }
}