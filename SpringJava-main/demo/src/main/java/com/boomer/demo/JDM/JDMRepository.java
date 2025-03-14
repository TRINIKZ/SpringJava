package com.boomer.demo.JDM;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boomer.demo.User.UserModel;

public interface JDMRepository extends JpaRepository<JDMModel, UUID>{

    UserModel findByModelo(String modelo);
    
}
