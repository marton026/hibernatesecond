package pl.sdacademy.hibernatesecond.repositories;

import pl.sdacademy.hibernatesecond.entities.Customer;
import pl.sdacademy.hibernatesecond.entities.ShoppingCart;

import javax.persistence.EntityManager;
import java.util.List;

// TODO: klasa repozytorium
public class CustomerRepository {

    // TODO: konteks utrwalania
    private EntityManager entityManager;

    public void addCustomer(Customer customer) {
        // TODO: metoda dodaje nowy obiekt Customer
    }

    public List<Customer> findAllCustomers() {
        // TODO: metoda zwraca listę wszystkich obiektów Customer
        return null;
    }

    public Customer findCustomerById(Long customerId) {
        // TODO: metoda zwraca obiekt Customer o zadanym id
        return null;
    }

    public Customer findCustomerByLogin(String login) {
        // TODO: metoda zwraca obiekt Customer o zadanym loginie
        return null;
    }

    public Customer findCustomerByFirstNameAndLastName(String firstName, String lastName) {
        // TODO: metoda zwraca obiekt Customer o zadanym imieniu i nazwisku
        return null;
    }

    public Customer addShoppingCartToCustomer(Long customerId, ShoppingCart shoppingCart) {
        // TODO: metoda dodaje koszyk dla klienta o zadanym id
        return null;
    }

    public Customer updateCustomer(Long customerId, Customer newCustomer) {
        // TODO: metoda modyfikuje obiekt Customer o zadanym id na właściwości obiektu przekazanego w parametrze
        return null;
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
