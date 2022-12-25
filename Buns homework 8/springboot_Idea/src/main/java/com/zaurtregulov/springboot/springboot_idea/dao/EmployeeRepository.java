package com.zaurtregulov.springboot.springboot_idea.dao;


import com.zaurtregulov.springboot.springboot_idea.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
