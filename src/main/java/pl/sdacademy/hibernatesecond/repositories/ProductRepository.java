package pl.sdacademy.hibernatesecond.repositories;

import pl.sdacademy.hibernatesecond.entities.Product;
import pl.sdacademy.hibernatesecond.entities.Tag;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

// TODO: klasa repozytorium
public class ProductRepository {

    // TODO: konteks utrwalania
    private EntityManager entityManager;

    public void addProduct(Product product) {
        // TODO: dodaje nowy produkt
    }

    public List<Product> findAllProducts() {
        // TODO: metoda wyszukuje wszystkie produkty
        return null;
    }

    public Product findProductById(Long productId) {
        // TODO: wyszukuje produkt po id
        return null;
    }

    public List<Product> findByPrice(BigDecimal price) {
        // TODO: wyszukuje produkty o zadanej cenie
        return null;
    }

    public List<Product> findByType(String type) {
        // TODO: wyszukuje produkty o podanym typie
        return null;
    }

    public List<Product> findAllProductsForSpecifiedTag(String tag) {
        // TODO: wyszukuje produkty dla podanego taga
        return null;
    }

    public void deleteProductById(Long productId) {
        // TODO: usuwa produkt o podanym id
    }

}
