package pl.sdacademy.hibernatesecond.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

// TODO: encja, nazwa tabeli: shopping_carts
public class ShoppingCart {

    // TODO: identyfikator, generowany automatycznie
    private Long id;

    // TODO: kolumna names
    private String name;

    // TODO: kolumna created
    private LocalDate created;

    // TODO: kolumna total_prices
    private BigDecimal totalPrice;

    // TODO: relacja jeden do jednego
    private Customer customer;

    // TODO: relacja jeden do wielu
    private List<Product> products;

    // TODO: getters setters
}
