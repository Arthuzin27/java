package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número de funcionários: ");
        int n = sc.nextInt();

        List<Funcionario> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Funcionário #" + i);
            System.out.print("Funcionário terceirizado (y/n)? ");
            char ch = sc.next().charAt(0);

            System.out.print("Digite o nome: ");
            sc.nextLine(); // limpar buffer
            String nome = sc.nextLine();

            System.out.print("Quantidade de horas: ");
            int horas = sc.nextInt();

            System.out.print("Valor por hora: ");
            double valorPorHora = sc.nextDouble();

            if (ch == 'y') {
                System.out.print("Taxa adicional: ");
                double valorAdicional = sc.nextDouble();
                Funcionario fun = new FuncionarioTercerizado(nome, horas, valorPorHora, valorAdicional);
                list.add(fun);
            } else {
                Funcionario fun = new Funcionario(nome, horas, valorPorHora);
                list.add(fun);
            }
        }

        System.out.println("\nPagamentos:");
        for (Funcionario f : list) {
            System.out.println(f.getNome() + " - R$ " + String.format("%.2f", f.pagamento()));
        }

        sc.close();
    }
}