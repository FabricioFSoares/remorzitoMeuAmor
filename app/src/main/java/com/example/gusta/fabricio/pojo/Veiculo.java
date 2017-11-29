package com.example.gusta.fabricio.pojo;

/**
 * Created by gusta on 28/11/2017.
 */

public class Veiculo {
    private String placa;
    private String cor;
    private String modelo;
    private String ano;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString(){
        return ""+this.placa+", "+this.ano+", "+this.cor+", "+this.modelo;
    }
}
