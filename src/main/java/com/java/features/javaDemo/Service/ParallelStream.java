package com.java.features.javaDemo.Service;

import com.java.features.javaDemo.Beans.Employee;

import javax.swing.*;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.IntStream;

public class ParallelStream {
    public static void main(String[] args) {

        long start = 0;
        long end = 0;

        /*
        start = System.currentTimeMillis();
        Double d = IntStream.range(1, 100000).average().getAsDouble();
        end = System.currentTimeMillis();
        System.out.println("Avg: "+ d +" Normal stream time: "+ (end-start));
        System.out.println("==================================");

        start = System.currentTimeMillis();
        Double average = IntStream.range(1, 1000).parallel().average().getAsDouble();
        end = System.currentTimeMillis();
        System.out.println("Avg: "+ average +" Parallel stream time: "+ (end-start));

         */


        // get avg salary of bulk emps
        ArrayList<Employee> employees = getBulkEmps();
        start = System.currentTimeMillis();
        Double average = employees.stream().map(emp -> emp.getSalary()).mapToInt(i -> i).average().getAsDouble();
        end = System.currentTimeMillis();
        System.out.println("Avg salary = " + average + " with normal/seq stream Time: "+ (end-start));

        start = System.currentTimeMillis();
        Double average_ = employees.parallelStream().map(emp -> emp.getSalary()).mapToInt(i -> i).average().getAsDouble();
        end = System.currentTimeMillis();
        System.out.println("Avg salary = " + average_ + " with parallel stream Time: "+ (end-start));
    }

    public static ArrayList<Employee> getBulkEmps() {
        ArrayList<Employee> empList = new ArrayList<>();
        for (int i=1; i <=1000000; i++){
            empList.add(new Employee(""+i, "Name"+i, Integer.valueOf(new Random().nextInt(100*10)), "city"+i));
        }
        return empList;
    }
}
