package pl.sdacademy.hibernatesecond.controllers;

import org.springframework.web.bind.annotation.*;
import pl.sdacademy.hibernatesecond.dtos.CustomerDTO;
import pl.sdacademy.hibernatesecond.entities.Customer;
import pl.sdacademy.hibernatesecond.entities.ShoppingCart;
import pl.sdacademy.hibernatesecond.repositories.CustomerRepository;

import java.util.List;


@RestController
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/customers")
    public void addCustomer(@RequestBody Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> findAllCustomers() {
       return customerRepository.findAllCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer findCustomerById(@PathVariable Long customerId) {
        return customerRepository.findCustomerById(customerId);
    }

    @GetMapping("/customers/login/{login}")
    public Customer findCustomerByLogin(@PathVariable String login) {
        return customerRepository.findCustomerByLogin(login);
    }

    @GetMapping("/customers/first/{firstName}/last/{lastName}")
    public Customer findCustomerByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
        return customerRepository.findCustomerByFirstNameAndLastName(firstName, lastName);
    }

    @PutMapping("/customers/{customerId}")
    public CustomerDTO addShoppingCartToCustomer(@PathVariable Long customerId, @RequestBody ShoppingCart shoppingCart) {
        return customerRepository.addShoppingCartToCustomer(customerId, shoppingCart);
    }

    @PutMapping("/customer/update/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId,@RequestBody Customer newCustomer) {
        return updateCustomer(customerId, newCustomer);
    }


}
