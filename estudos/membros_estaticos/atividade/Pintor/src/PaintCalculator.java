public class PaintCalculator {

    // Cada litro cobre 10m²
    private static final double COBERTURA_POR_LITRO = 10.0;

    public static double calculateArea(double altura, double largura) {
        return altura * largura;
    }

    public static double calculateLiters(double area) {
        return area / COBERTURA_POR_LITRO;
    }

    public static double calculateCost(double litros, double precoPorLitro) {
        return litros * precoPorLitro;
    }
}