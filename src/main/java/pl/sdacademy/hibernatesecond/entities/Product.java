package pl.sdacademy.hibernatesecond.entities;

import java.math.BigDecimal;
import java.util.List;

// TODO: encja, nazwa tabeli: products
public class Product {

    // TODO: identyfikator, generowany automatycznie
    private Long id;

    // TODO: kolumna product_names
    private String name;

    // TODO: kolumna product_types
    private String type;

    // TODO: kolumna product_prices
    private BigDecimal price;

    // TODO: relacja wiele do jednego
    private ShoppingCart shoppingCart;

    // TODO: relacja wiele do wielu
    private List<Tag> tags;

    // TODO: getters setters

}
