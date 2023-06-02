package com.java.features.javaDemo.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Reduce {

    public static void  main(String[] args){
        primitiveListOps();

    }

    public static void primitiveListOps() {

        List<Integer> intList = Arrays.asList(1,3,4,9);

        List<String> strList = Arrays.asList("java", "spring-boot", "micro-services");

        //Sum of intList
        int sum = 0;
        for (int i:intList) {
            sum = sum + i;
        }
        System.out.println("Sum with iteration/traditional way: "+ sum);

        //stream reduce methos
        int basicStreamSum = intList.stream().mapToInt(i->i).sum();
        System.out.println("basicStreamSum: "+basicStreamSum);

        Integer sumWithReduce = intList.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sumWithReduce: "+ sumWithReduce);

        Integer sumWithReduceMethodRef = intList.stream().reduce(Integer::sum).get();
        System.out.println("sumWithReduceMethodRef: "+sumWithReduceMethodRef);

        Integer maxNum = intList.stream().reduce(Integer::max).get();
        System.out.println("maxNum: "+maxNum);

        Integer minNum = intList.stream().reduce(Integer::min).get();
        System.out.println("minNum: "+minNum);

        Integer multiplication = intList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("multiplication: "+multiplication);

        //get longest string
        String longestString = strList.stream()
                .reduce((str1, str2) -> str1.length() > str2.length() ? str1 : str2)
                .get();
        System.out.println("longestString: "+longestString);


    }
}
