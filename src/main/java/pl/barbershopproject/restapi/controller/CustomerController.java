package pl.barbershopproject.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.barbershopproject.restapi.model.Customer;
import pl.barbershopproject.restapi.model.Employee;
import pl.barbershopproject.restapi.service.CustomerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    // create
    @PostMapping("")
    public Customer addCustomer(@RequestBody Customer customer) {

        return customerService.addCustomer(customer);
    }

// read
    @GetMapping("")
    public List<Customer> getCustomers() {

        return customerService.getCustomers();

    }
    @GetMapping("/{id_customer}")
    public Customer getSingleCustomer(@PathVariable long id_customer){
        return customerService.getSingleCustomer(id_customer);
    }

    // update

    //delete
    @DeleteMapping("/{id_customer}")
    public void deleteCustomer(@PathVariable long id_customer){

        customerService.deleteCustomer(id_customer);
    }



}
