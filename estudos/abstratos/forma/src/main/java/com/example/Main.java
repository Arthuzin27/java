package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.example.entities.Circulo;
import com.example.entities.Color;
import com.example.entities.Forma;
import com.example.entities.Retangulo;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner (System.in);

        List <Forma> list = new ArrayList<>();

        System.out.print("Quantas formas serão inseridas? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Forma #"+i);
            System.out.print("É um círculo ou um retangulo? (c/r)" );
            char ch = sc.next().charAt(0);
            System.out.println("Cor: (BLACK, BLUE, RED): "); 
            Color color = Color.valueOf(sc.next());
            if(ch == 'r'){
                System.out.println("Largura: ");  
                double largura = sc.nextDouble();
                System.out.println("Altura: ");  
                double altura = sc.nextDouble();
                list.add(new Retangulo(color, largura,altura));
            } else{
                System.out.println("Raio: ");
                double raio = sc.nextDouble();
                list.add(new Circulo (color, raio));
            }
        }
        System.err.println();
        System.out.println("Valor das Areas: ");
        for(Forma forma : list){
            System.out.println(forma.area());
        }
    }
}   