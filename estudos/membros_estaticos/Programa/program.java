package Programa;

import java.util.Locale;
import java.util.Scanner;
import Calculator.calculator;

public class program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter radius: ");

        double radius = sc.nextDouble();
        double c = calculator.circunference(radius);
        double v = calculator.volume(radius);

        System.out.printf("Circumference: %.2f%n", c);
        System.out.printf("Volume: %.2f%n", v);
        System.out.printf("PI value: %.2f%n", calculator.PI);

        sc.close();
    }

}


/* Os membros estáticos servem para chamar uma classe sem instanciar, mas você so consegue chamar essa classe dentro do método main */