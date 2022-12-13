package com.zaurtregulov.spring.rest;

import com.zaurtregulov.spring.rest.configuration.MyConfig;
import com.zaurtregulov.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args ) {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(MyConfig.class);
    Communication commucation = context.getBean("communication", Communication.class);

        List<Employee> allEmployees = commucation.getAllEmployees();
        System.out.println(allEmployees);

        Employee empByID = commucation.getEmployee(4);
        System.out.println(empByID);

            Employee emp = new Employee("Ivan", "Ivanov", "IT", "20000");

            emp.setId(5);
             commucation.saveEmployee(emp);

         }
         commucation.deleteEmployee(6);
        }
