package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Quantas pessoas serão adicionadas?");
        int n = sc.nextInt();

        List<Pessoa> list = new ArrayList<>(n);

        System.out.print("PF ou PJ (F/J): ");
        char ch = sc.next().toUpperCase().charAt(0);

        sc.nextLine(); // limpa o buffer antes de ler o nome

        System.out.println();

        if (ch == 'F') {
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Gasto Anual: ");
            double rendaAnual = sc.nextDouble();

            System.out.print("Gasto com saúde: ");
            double gastoComSaude = sc.nextDouble();

            list.add(new PessoaFisica(nome, rendaAnual, gastoComSaude));

        } else {
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Gasto Anual: ");
            double rendaAnual = sc.nextDouble();

            System.out.print("Quantidade de Funcionários: ");
            int numeroDeFuncionarios = sc.nextInt();

            list.add(new PessoaJuridica(nome, rendaAnual, numeroDeFuncionarios));
        }

        System.out.println("\n--- Lista de Pessoas ---");
        for (Pessoa p : list) {
            System.out.println(p);
        }

        sc.close();
    }
}