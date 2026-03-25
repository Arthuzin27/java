package com.example.Application;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;



public class Program {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        Set<String> set2 = new TreeSet<>();
        Set<String> set3 = new LinkedHashSet<>();

        set.add("TV");
        set.add("Notebook");
        set.add("Tablet");

        set2.add("TV");
        set2.add("Notebook");
        set2.add("Tablet");

        set3.add("TV");
        set3.add("Notebook");
        set3.add("Tablet");

        set.remove("Tablet");
        set2.removeIf(x -> x.length() >= 3); /* remover a partir de alguma coisa. nesse caso removeu
                                             todos que tem pelo menos 3 letras */

        System.out.println(set.contains("Notebook")); /* Verifica se existi Notebook em algum set */

        System.out.println("-----------------SEM ORDEM-----------------");

        for(String p : set){
            System.out.println(p);
        }

        System.out.println("--------------ORDEM-----------------");

        for(String p : set2){
            System.out.println(p);
        }

         System.out.println("----------------ELEMeNTOS INSERIDOS------------------");

           for(String p : set3){
            System.out.println(p);
        }
    }
}
