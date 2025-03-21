package com.boomer.demo.JDM;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JDMRepository extends JpaRepository<JDMModel, UUID>{
    JDMModel findByModelo(String modelo);

    JDMModel findByUsermame(String username);
}
