package com.example.ecodrive;

public class Combustivel_Class {
    private Long id;
    private float valorCombustivel;
    private float valorAbastecido;
    private float kmAtual;

    public Combustivel_Class(Long id, float valorCombustivel, float valorAbastecido, float kmAtual) {
        this.id = id;
        this.valorCombustivel = valorCombustivel;
        this.valorAbastecido = valorAbastecido;
        this.kmAtual = kmAtual;
    }

    public Combustivel_Class(float valorCombustivel, float valorAbastecido, float kmAtual) {
        this.valorCombustivel = valorCombustivel;
        this.valorAbastecido = valorAbastecido;
        this.kmAtual = kmAtual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getValorCombustivel() {
        return valorCombustivel;
    }

    public void setValorCombustivel(float valorCombustivel) {
        this.valorCombustivel = valorCombustivel;
    }

    public float getValorAbastecido() {
        return valorAbastecido;
    }

    public void setValorAbastecido(float valorAbastecido) {
        this.valorAbastecido = valorAbastecido;
    }

    public float getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(float kmAtual) {
        this.kmAtual = kmAtual;
    }
}
