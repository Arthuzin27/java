package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import entities_enums.Nivel;

public class Trabalhador {
    private String nome;
    private Nivel nivel;
    private double baseSalario;

    private Departamento departamento;
    private List<HorasContrato> contratos = new ArrayList<>();

    public Trabalhador() {

    }

    public Trabalhador(String nome, Nivel nivel, double baseSalario, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.baseSalario = baseSalario;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public double getBaseSalario() {
        return baseSalario;
    }

    public void setBaseSalario(double baseSalario) {
        this.baseSalario = baseSalario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<HorasContrato> getContratos() {
        return contratos;
    }

    public void adicionarContrato(HorasContrato contrato) {
        contratos.add(contrato);
    }

    public void removerContrato(HorasContrato contrato) {
        contratos.remove(contrato);
    }

    public double renda(int ano, int mes) {
        double soma = baseSalario;
        Calendar cal = Calendar.getInstance();
        for (HorasContrato h : contratos) {
            cal.setTime(h.getDate());
            int h_ano = cal.get(Calendar.YEAR);
            int h_mes = cal.get(Calendar.MONTH);
            if (ano == h_ano && mes == h_mes) {
                soma = h.valorTotal();
            }
        }
        return soma;
    }

}
