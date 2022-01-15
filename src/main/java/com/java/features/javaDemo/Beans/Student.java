package com.java.features.javaDemo.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private String city;
    private List<String> phoneNumbers;

    public String toString(){
       return "Id: "+ this.id + " Name: "+ this.name + " City: "+ this.city+ " phoneNumbers: "+ this.phoneNumbers;
    }
}
