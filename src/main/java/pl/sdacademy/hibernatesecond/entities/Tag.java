package pl.sdacademy.hibernatesecond.entities;

import java.util.List;

// TODO: enzja, nazwa tabeli: tags
public class Tag {

    // TODO: identyfikator, generowany automatycznie
    private Long id;

    // TODO: kolumna tag_names
    private String tagName;

    // TODO: relacja wiele do wielu
    private List<Product> products;

    // TODO: getters setters
}
