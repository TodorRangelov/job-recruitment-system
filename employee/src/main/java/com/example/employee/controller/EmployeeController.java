package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    private int num = 0;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees() {

        return empService.getAllEmployees();

    }

    @GetMapping("get")
    public List<Employee> get() {
        return empService.getAllEmployees();
    }

    @RequestMapping(value = "/insertemployee", method = RequestMethod.POST)
    public void insertEmployee(@RequestBody Employee employee) {
        empService.insertEmployee(employee);
    }


    @GetMapping("getNum")
    public int getNum() {
        num = num + 1;
        return num;
    }
}
// mvn packge
// docker image build -t employee-jdbc .
// docker container run --network employee-mysql --name employee-jdbc-container -p 8080:8080 -d employee-jdbc
