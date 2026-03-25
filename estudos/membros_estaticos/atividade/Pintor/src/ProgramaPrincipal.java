import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Altura da parede (m): ");
        double altura = sc.nextDouble();

        System.out.print("Largura da parede (m): ");
        double largura = sc.nextDouble();

        System.out.print("Preço do litro da tinta (R$): ");
        double precoPorLitro = sc.nextDouble();

        double area = PaintCalculator.calculateArea(altura, largura);
        double litros = PaintCalculator.calculateLiters(area);
        double custo = PaintCalculator.calculateCost(litros, precoPorLitro);

        System.out.printf("Área da parede: %.2f m²%n", area);
        System.out.printf("Quantidade de tinta necessária: %.2f litros%n", litros);
        System.out.printf("Custo total: R$ %.2f%n", custo);

        sc.close();
    }
}