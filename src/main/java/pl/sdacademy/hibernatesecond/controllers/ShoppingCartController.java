package pl.sdacademy.hibernatesecond.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.hibernatesecond.entities.ShoppingCart;
import pl.sdacademy.hibernatesecond.repositories.ShoppingCartRepository;
import pl.sdacademy.hibernatesecond.repositories.UserRepository;

import java.util.List;

@RestController
public class ShoppingCartController {

    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @GetMapping("/shoppingcart")
    public List<ShoppingCart> findAllShoppingCarts() {
        return shoppingCartRepository.findAllShoppingCarts();
    }
}
