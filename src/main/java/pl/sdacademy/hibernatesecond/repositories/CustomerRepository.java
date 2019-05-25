package pl.sdacademy.hibernatesecond.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.hibernatesecond.dtos.CustomerDTO;
import pl.sdacademy.hibernatesecond.entities.Customer;
import pl.sdacademy.hibernatesecond.entities.ShoppingCart;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Transactional
    public List<Customer> findAllCustomers() {
        List<Customer> customers = entityManager.createQuery("from Customer", Customer.class).getResultList();
        return customers;
    }

    @Transactional
    public Customer findCustomerById(Long customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        return customer;
    }

    @Transactional
    public Customer findCustomerByLogin(String login) {
        Customer customer = entityManager.createQuery("from Customer c where c.login=:login", Customer.class)
                .setParameter("login", login)
                .getSingleResult();
        return customer;
    }

    @Transactional
    public Customer findCustomerByFirstNameAndLastName(String firstName, String lastName) {
        Customer customer = entityManager.createQuery("from Customer c where c.firstName=:firstName and " +
                "c.lastName=:lastName", Customer.class)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .getSingleResult();
        return customer;
    }

    @Transactional
    public CustomerDTO addShoppingCartToCustomer(Long customerId, ShoppingCart shoppingCart) {
        Customer customer = entityManager.find(Customer.class, customerId);
        customer.setShoppingCart(shoppingCart);
        shoppingCart.setCustomer(customer);
        Customer mergeCustomer = entityManager.merge(customer);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(mergeCustomer.getId());
        customerDTO.setFirstName(mergeCustomer.getFirstName());
        customerDTO.setLastName(mergeCustomer.getLastName());
        customerDTO.setLogin(mergeCustomer.getLogin());
        customerDTO.setPassword(mergeCustomer.getPassword());

        return customerDTO;

    }

    @Transactional
    // TODO: metoda modyfikuje obiekt Customer o zadanym id na właściwości obiektu przekazanego w parametrze
    public Customer updateCustomer(Long customerId, Customer newCustomer) {

        Customer customer = findCustomerById(customerId);
        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
        customer.setLogin(newCustomer.getLogin());
        customer.setPassword(newCustomer.getPassword());

        return entityManager.merge(customer);
    }

    public Customer changePassword(Long customerId, String newPassword) {
        // TODO: metoda modyfikuje hasło użytkownika
        return null;
    }

    public Customer changeShoppingCart(Long customerId, ShoppingCart newShoppingCart) {
        // TODO: metoda modyfikuje koszyk użytkownika
        return null;
    }

    public void deleteCustomerById(Long customerId) {
        // TODO: metoda usuwa danego użytkownika
    }

    public void deleteCustomersShoppingCart(Long customerId) {
        // TODO: metoda usuwa koszyk danego użytkownika
    }

}
