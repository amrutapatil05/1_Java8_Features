package com.java.features.javaDemo.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String id;
    private String name;
    private int salary;
    private String city;

 public String toString(){
 return "ID: "+ this.id + " Name: "+ this.name + " Salary: "+ this.salary + " City: "+this.city;
 }
}
