package com.example.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.entities.Employee;

public class Program {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        String path = "C:\\temp\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String employeCsv = br.readLine();
            while (employeCsv != null) {

                String[] fields = employeCsv.split("\\s*,\\s*");

                list.add(new Employee(
                        fields[0],
                        Double.parseDouble(fields[1])));

                employeCsv = br.readLine();
            }

            Collections.sort(list);
            for (Employee emp : list) {
                System.out.println(emp.getName() + ", " + emp.getSalary());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}