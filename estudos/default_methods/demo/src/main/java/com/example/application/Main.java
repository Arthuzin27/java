package com.example.application;

import java.util.Locale;
import java.util.Scanner;

import com.example.service.BrazilInterestService;
import com.example.service.UsaInterestService;
import com.example.service.InterestService;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();

        InterestService is = new UsaInterestService(1.0);
        double payment = is.payment(amount, months);

        System.out.println("Payment after: " + months + "Months: ");
        System.out.println(String.format("%.2f" , payment));
    }
} 