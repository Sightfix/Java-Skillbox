package com.zaurtregulov.springboot.springboot_rest.dao;

import com.zaurtregulov.springboot.springboot_rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
