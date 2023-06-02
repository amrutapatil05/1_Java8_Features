package com.java.features.javaDemo.Service;

import com.java.features.javaDemo.Beans.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Map_flatMap_Demo {
    public static void main(String a[]){
     listOfAvailableCities(); // map implementation
        listOfAvailablePhoneNumbers(); // flatMap implementation
    }

    public static List<Student> getStudentList(){
        return Stream.of(
                new Student(1, "Jenny", "Mexico", Arrays.asList("23451", "45632")),
                new Student(2, "Bunny", "Japan", Arrays.asList("23451", "45632")),
                new Student(3, "Sunny", "Mumbai", Arrays.asList("23451", "45632")),
                new Student(4, "Keny", "Mumbai", Arrays.asList("23451", "45632")),
                new Student(5, "Tony", "Brisbane", Arrays.asList("23451", "45632"))
        ).collect(Collectors.toList());
    }

    public static void listOfAvailableCities(){
        List<Student> studentList = getStudentList();
        System.out.println("original list: "+ studentList);
        //Map: one to one mapping, print list of all cities
        List<String> cities = studentList.stream()
                .map(student -> student.getCity().toUpperCase())
                .collect(Collectors.toList());
        System.out.println("List of All available cities in upperCase: "+ cities);
        List<String> distinctCities = studentList.stream()
                .map(student -> student.getCity().toLowerCase())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("List of distinct available cities in lowerCase: "+ distinctCities);
    }

    public static void listOfAvailablePhoneNumbers(){
        List<Student> studentList = getStudentList();
        System.out.println("Original list: "+ studentList);

        List<List<String>> phoneNumbers = studentList.stream().map(student -> student.getPhoneNumbers())
                .collect(Collectors.toList());
        System.out.println("All available phone numbers with map: "+ phoneNumbers);

        // flatmap takes stream as input & returns stream as output: one to many
        List<String> phoneNumbers_ = studentList.stream().flatMap(student -> student.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println("All available phone numbers with flatMap: "+ phoneNumbers_);

        List<String> distinct_phoneNumbers_ = studentList.stream()
                .flatMap(student -> student.getPhoneNumbers().stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("All distinct phone numbers with flatMap: "+ distinct_phoneNumbers_);

    }
}
