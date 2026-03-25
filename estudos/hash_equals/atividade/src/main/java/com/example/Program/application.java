package com.example.Program;

import com.example.Entities.Client;

public class application {
    
    public static void main(String[] args) {
        
        Client c1 = new Client("Arthur", "arthutlopes@gmail.com");
        Client c2 = new Client("Alex", "arthutlopes@gmail.com");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.equals(c2));
    }
}
