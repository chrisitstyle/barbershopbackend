package pl.barbershopproject.restapi.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.barbershopproject.restapi.model.Customer;
import pl.barbershopproject.restapi.model.Employee;
import pl.barbershopproject.restapi.repository.EmployeeRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    // create
    public Employee addEmployee(Employee employee) {
        Optional<Employee> employeeFromDatabase = employeeRepository.findByEmail(employee.getEmail());
        if (employeeFromDatabase.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Pracownik o podanym e-mail istnieje");
        }

        return employeeRepository.save(employee);
    }
    // read
    public List<Employee> getEmployees() {
        return employeeRepository.findAll(); // wszyscy pracownicy z repo, czyli z bazy
    }

    public Employee getSingleEmployee(long id_employee) {
        return employeeRepository.findById(id_employee).orElseThrow();
    }

    //update
    public Employee updateEmployee(Employee updatedEmployee, Long id_employee){
        return employeeRepository.findById(id_employee)
                .map(employee -> {
                    employee.setFirstName(updatedEmployee.getFirstName());
                    employee.setLastName(updatedEmployee.getLastName());
                    employee.setEmail(updatedEmployee.getEmail());
                    employee.setPassword(updatedEmployee.getPassword());
                    return employeeRepository.save(employee);
                } ).orElseThrow(NoSuchElementException::new);
    }

    //delete
    public void deleteEmployee(long id_employee) {

        employeeRepository.deleteById(id_employee);
        System.out.println("employee with id " + id_employee + " has been deleted");

    }


}
