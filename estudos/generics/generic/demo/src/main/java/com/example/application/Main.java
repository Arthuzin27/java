package com.example.application;

import java.util.Scanner;

import com.example.service.PrintService;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        PrintService <Integer> ps = new PrintService<>();

        System.out.println("How Many Values: ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int value = sc.nextInt();
            ps.addValue(value);
        }

        ps.print();
        System.out.println("First: " + ps.first());
    }
}