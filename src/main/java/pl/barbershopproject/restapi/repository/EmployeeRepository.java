package pl.barbershopproject.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.barbershopproject.restapi.model.Employee;

import java.util.Optional;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);


}
