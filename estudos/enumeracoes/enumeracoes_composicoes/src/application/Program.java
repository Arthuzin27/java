package application;

import entities.Trabalhador;
import entities.Departamento;
import entities.HorasContrato;
import entities_enums.Nivel;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Digite o nome do departamento: ");
        String nomeDepartamento = sc.nextLine();

        System.out.println("Digite os dados do trabalhador:");
        System.out.print("Digite o nome do trabalhador: ");
        String nomeTrabalhador = sc.nextLine();

        System.out.print("Digite o nivel do trabalhador (JUNIOR, MID_LEVEL, SENIOR): ");
        String nivelTrabalhador = sc.nextLine();

        System.out.print("Digite o salario base do trabalhador: ");
        double baseSalario = sc.nextDouble();

        Trabalhador trabalhador = new Trabalhador(
                nomeTrabalhador,
                Nivel.valueOf(nivelTrabalhador.toUpperCase()), // para garantir que bate com o enum
                baseSalario,
                new Departamento(nomeDepartamento)
        );

        System.out.print("Quantos contratos esse trabalhador vai ter? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do contrato #" + i + ":");
            System.out.print("Data (DD/MM/YYYY): ");
            sc.nextLine(); // limpa o buffer antes do next()
            Date contratoDate = sdf.parse(sc.nextLine());

            System.out.print("Valor por hora: ");
            double valorPorHora = sc.nextDouble();

            System.out.print("Duração (em horas): ");
            int horas = sc.nextInt();

            HorasContrato contrato = new HorasContrato(contratoDate, valorPorHora, horas);
            trabalhador.adicionarContrato(contrato);
        }

        System.out.print("Entre com o mês e ano para calcular a renda (MM/YYYY): ");
        sc.nextLine(); // limpa o buffer antes do nextLine()
        String mesEano = sc.nextLine();

        int mes = Integer.parseInt(mesEano.substring(0, 2));
        int ano = Integer.parseInt(mesEano.substring(3));

        System.out.println();
        System.out.println("Nome: " + trabalhador.getNome());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
        System.out.printf("Renda em %s: %.2f\n", mesEano, trabalhador.renda(mes, ano));

        sc.close();
    }
}