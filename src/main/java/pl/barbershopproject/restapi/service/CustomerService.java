package pl.barbershopproject.restapi.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.barbershopproject.restapi.model.Customer;
import pl.barbershopproject.restapi.model.Employee;
import pl.barbershopproject.restapi.repository.CustomerRepository;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    // create
    public Customer addCustomer(Customer customer) {
        Optional<Customer> customerFromDatabase = customerRepository.findByEmail(customer.getEmail());
        if (customerFromDatabase.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Klient o podanym e-mail istnieje");
        }

        return customerRepository.save(customer);
    }
    // read
    public List<Customer> getCustomers() {
        return customerRepository.findAll(); // wszyscy klienci z repo, czyli z bazy
    }

    public Customer getSingleCustomer(long id_customer) {
        return customerRepository.findById(id_customer).orElseThrow(NoSuchElementException::new);

    }
    //update

    public Customer updateCustomer(Customer updatedCustomer, Long id_customer){
        return customerRepository.findById(id_customer)
                .map(customer -> {
                    customer.setFirstName(updatedCustomer.getFirstName());
                    customer.setLastName(updatedCustomer.getLastName());
                    customer.setEmail(updatedCustomer.getEmail());
                    customer.setPassword(updatedCustomer.getPassword());
                    return customerRepository.save(customer);
                } ).orElseThrow(NoSuchElementException::new);
    }
    //delete
    public void deleteCustomer(long id_customer) {

        customerRepository.deleteById(id_customer);
        System.out.println("customer with id " + id_customer + " has been deleted");

    }


}
