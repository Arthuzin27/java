package entities;
import java.util.Date;

public class HorasContrato {

    private Date date;
    private double valorPorHora;
    private Integer horas;

    public HorasContrato() {

    }

    public HorasContrato(Date date, double valorPorHora, Integer horas) {
        this.date = date;
        this.valorPorHora = valorPorHora;
        this.horas = horas;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public double valorTotal(){
        return valorPorHora * horas;
    }
    
}
