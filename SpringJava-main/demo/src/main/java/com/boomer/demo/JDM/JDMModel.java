package com.boomer.demo.JDM;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity (name = "tb_jdm")

public class JDMModel {

    @Id
    @GeneratedValue (generator = "UUID")
    private UUID carro;
    private String modelo;
    private String marca;
    private String ano;
    private String rato;

    public UUID getId() {
        return carro;
    }
    public void setId(UUID carro) {
        this.carro = carro;
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
        // TODO Auto-generated method stub
        return rato;
    }
    public void setSenha(String rato) {
        this.rato = rato;
    }
}
    
