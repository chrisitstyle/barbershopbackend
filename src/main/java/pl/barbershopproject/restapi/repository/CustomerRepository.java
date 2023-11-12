package pl.barbershopproject.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.barbershopproject.restapi.model.Customer;
import pl.barbershopproject.restapi.model.Employee;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository <Customer, Long> {

    Optional<Customer> findByEmail(String email);
}
