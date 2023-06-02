package com.java.features.javaDemo.Controller;

import com.java.features.javaDemo.Beans.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MyController {

    @RequestMapping("/")
    public String loginStatus() {
        return "Health Check Successful..";
    }

    @GetMapping("/getBaseList")
    public ArrayList<Employee> getList() {
        return new ArrayList<>();
    }
}
