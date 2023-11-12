package pl.barbershopproject.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.barbershopproject.restapi.model.Customer;
import pl.barbershopproject.restapi.model.Employee;
import pl.barbershopproject.restapi.service.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    // create
    @PostMapping("")
    public Employee addEmployee(@RequestBody Employee employee) {

        return employeeService.addEmployee(employee);
    }

// read
    @GetMapping("")
    public List<Employee> getEmployees() {

        return employeeService.getEmployees();

    }
    @GetMapping("/{id_employee}")
    public Employee getSingleEmployee(@PathVariable long id_employee){
        return employeeService.getSingleEmployee(id_employee);
    }

    // update
    @PutMapping("/{id_employee}")
    public Employee updateEmployee(@RequestBody Employee updatedCustomer, @PathVariable Long id_employee){
        return employeeService.updateEmployee(updatedCustomer, id_employee);
    }
    //delete
    @DeleteMapping("/{id_employee}")
    public void deleteEmployee(@PathVariable long id_employee){

        employeeService.deleteEmployee(id_employee);
    }



}
