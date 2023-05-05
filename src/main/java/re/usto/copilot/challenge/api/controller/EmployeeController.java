package re.usto.copilot.challenge.api.controller;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import re.usto.copilot.challenge.api.controller.model.Employee;
import re.usto.copilot.challenge.api.controller.model.EmployeeForm;
import re.usto.copilot.challenge.api.controller.repositorty.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody @Valid EmployeeForm form){
        Employee newEmployee = new Employee(form);
        return new ResponseEntity<>(employeeRepository.save(newEmployee), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }








}
