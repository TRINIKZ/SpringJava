package com.boomer.demo.JDM;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity (name = "tb_jdm")

public class JDMModel {

    @Id
    @GeneratedValue (generator = "UUID")
    private UUID id;
    private String modelo;
    private String marca;
    private String ano;
    private String senha;

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senhaHash) {
        this.senha = senhaHash;
    }
    
}