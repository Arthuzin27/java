package com.example.application;

import com.example.entities.ComboDevice;
import com.example.entities.ConcretePrinter;
import com.example.entities.ConcreteScanner;

public class Program {
    
    public static void main(String[] args) {
        
        ConcretePrinter p = new ConcretePrinter ("1080");
        p.processDoc("My Letter");
        p.print ("My Letter");

        System.out.println();
        ConcreteScanner s = new ConcreteScanner ("2003");
        s.processDoc("My email");
        System.out.println("Scan result: " + s.scan());

        System.out.println();
        ComboDevice c = new ComboDevice("2081");
        c.processDoc("My dissertation");
        c.print ("My dissertation");
        System.out.println("Scan Result: " + c.scan());
    }
}
