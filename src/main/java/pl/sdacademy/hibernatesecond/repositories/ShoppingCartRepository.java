package pl.sdacademy.hibernatesecond.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.hibernatesecond.entities.Product;
import pl.sdacademy.hibernatesecond.entities.ShoppingCart;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ShoppingCartRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ShoppingCart findShoppingCartById(Long id) {
        // TODO: znajduje koszyk o zadanym id
        return null;
    }

    public ShoppingCart findShoppingCartByCustomerId(Long customerId) {
        // TODO: zwraca koszyk dla klienta o zadanym id
        return null;
    }

    @Transactional
    public List<ShoppingCart> findAllShoppingCarts() {
        List<ShoppingCart> list = entityManager.createQuery("from ShoppingCart",ShoppingCart.class)
                .getResultList();
        return list;
    }

    public ShoppingCart findMostExpensiveShoppingCart() {
        // TODO: znajduje koszyk z najwyższym totalPrice
        return null;
    }

    public int countShoppingCarts() {
        // TODO: zwraca liczbę koszyków
        return 0;
    }

    public ShoppingCart findOldestShoppingCart() {
        // TODO: znajduje koszyk z najstarszą datą created
        return null;
    }

    public ShoppingCart findNewestShoppingCart() {
        // TODO: znajduje koszyk z najnowszą datą created
        return null;
    }

    public ShoppingCart addProductToShoppingCart(Long cartId, Product product) {
        // TODO: dodaje produkt do koszyka o danym id
        return null;
    }

    public ShoppingCart addProductsToShoppingCart(Long cartId, List<Product> products) {
        // TODO: dodaje liste produktów do koszyka o danym id
        return null;
    }

    public void deleteShoppingCart(Long cartId) {
        // TODO: usuwa koszyk o podanym id
    }


}
