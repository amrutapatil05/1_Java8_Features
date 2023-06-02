package com.java.features.javaDemo.Service;

import com.java.features.javaDemo.Beans.Student;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) throws Exception {

        Student student = new Student(1, null, "Pune", Arrays.asList("34567", "76541", "90800"));
        //Optional<String> nameOptional = Optional.of(student.getName()); //null pointer exception if name = null

        Optional<String> nameOptional = Optional.ofNullable(student.getName()); //return empty optional if name = null
        if(nameOptional.isPresent()) System.out.printf("nameOptional: "+ nameOptional.get()); //without if, null pointer exception occurs

        String name = Optional.ofNullable(student.getName()).orElse("DefaultValue"); //return default optional if name = null
        System.out.println(name);

        // search if name present in given list with optional, stream
        String searchFor = "Jenny";
        List<Student> studentList = Map_flatMap_Demo.getStudentList();
        System.out.println("Original list: "+ studentList);
//        Student s = studentList.stream().filter(st -> st.getName().equalsIgnoreCase(searchFor)).findAny().get(); // this will thro no value present
//        Student s = studentList.stream().filter(st -> st.getName().equalsIgnoreCase(searchFor)).findAny().orElseThrow(() -> new Exception("Not Found")); // this will thro own exceptiont
        Student s = studentList.stream().filter(st -> st.getName().equalsIgnoreCase(searchFor)).findAny().orElse(new Student()); // empty student
        System.out.println("Record with name: "+ searchFor +" is: " + s);
    }
}
