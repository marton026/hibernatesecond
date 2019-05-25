package pl.sdacademy.hibernatesecond.controllers;

import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.hibernatesecond.repositories.ProductRepository;


@RestController
public class ProductController {

  private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
