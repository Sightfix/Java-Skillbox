package com.zaurtregulov.spring.rest;

import com.zaurtregulov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/RestTask/api/employees";

    public List<Employee> getAllEmployees(){

        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null
                        , new ParameterizedTypeReference<List<Employee>>(){});
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getEmployee(int id){
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;
    }

    public void saveEmployee(Employee employee){
        int id = employee.getId();

        if(id==0){
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL,employee, String.class);
            System.out.println("Новый работник добавлен в БД");
            System.out.println(responseEntity.getBody());
        }
        else {
            restTemplate.put(URL, employee);
            System.out.println("Работник с ID = " + id + " был обновлен");
        }
    }

    public void deleteEmployee(int id){
        restTemplate.delete(URL + "/" + id);
        System.out.println("Работник с id = " + id + " был удален");
    }
}
