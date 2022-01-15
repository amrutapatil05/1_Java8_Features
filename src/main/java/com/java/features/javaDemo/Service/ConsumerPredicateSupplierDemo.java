package com.java.features.javaDemo.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ConsumerPredicateSupplierDemo {
    public static void main(String s[]){
    //ConsumerDemo.performDemo();
     //   PredicateDemo.performDemo();
        SuplierDemo.performDemo();
    }
}

class PredicateDemo{
    public static void performDemo() {
        Predicate<Integer> predicate = i -> i>=5;

        //System.out.println(predicate.test(3));

        List intList = Arrays.asList(1, 2, 13, 14, 15);
        // Using predicate object
        /*intList.stream()
                .filter(predicate)
                .forEach(in -> System.out.println("value : " + in));
*/
        // using inline predicate with lambda
        intList.stream()
                .filter(t -> (int)t > 5)
                .forEach(in -> System.out.println("value : " + in));

    }
}
class ConsumerDemo {
    public static void performDemo(){
        // 1. Consumer demo
        // Consumer<Integer> consumer = (in -> System.out.println("Accepting input =  "+ in));
        //consumer.accept(10);
        List intList = Arrays.asList(2,1,3,4,5);
        //intList.forEach(consumer);
        intList.forEach(in -> System.out.println("input = " + in));

    }
}
class SuplierDemo {
    public static void performDemo() {
        Supplier<String> supplier = () -> "Result";
        //System.out.println(supplier.get());

        List<String> intList = Arrays.asList("A", "B", "C", "D", "A");

        //System.out.println(intList.stream().findAny().orElseGet(supplier));
        String searchFor = "B";
        System.out.println(intList.stream()
                        .filter(t -> t.equalsIgnoreCase(searchFor))
                        .findAny().orElseGet(() -> "Not Found"));
    }
}