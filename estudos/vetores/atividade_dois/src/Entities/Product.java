package Entities;

public class Product {

    private String name;
    private double price;

    public Product(String nome, double price) {
        this.name = nome;
        this.price = price;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Produto: " + name + ", Preço: R$ " + String.format("%.2f", price);
    }
}