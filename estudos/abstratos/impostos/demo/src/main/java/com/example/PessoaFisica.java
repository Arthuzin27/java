package com.example;

public class PessoaFisica extends Pessoa {

    private Double gastoComSaude;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, Double rendaAnual, Double gastoComSaude) {
        super(nome, rendaAnual);
        this.gastoComSaude = gastoComSaude;
    }

    public Double getGastoComSaude() {
        return gastoComSaude;
    }

    public void setGastoComSaude(Double gastoComSaude) {
        this.gastoComSaude = gastoComSaude;
    }

    @Override
    public double imposto() {
        double impostoBasico;
        if (getRendaAnual() < 20000.0) {
            impostoBasico = getRendaAnual() * 0.15;
        }else{
            impostoBasico = getRendaAnual() * 0.25;
        }
        impostoBasico = impostoBasico - (getGastoComSaude() * 0.5);
        if(impostoBasico < 0.0){
            return 0.0;
        }else{
            return impostoBasico;
        }
    }
}
