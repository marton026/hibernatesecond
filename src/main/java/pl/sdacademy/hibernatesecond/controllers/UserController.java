package pl.sdacademy.hibernatesecond.controllers;

import org.springframework.web.bind.annotation.*;
import pl.sdacademy.hibernatesecond.entities.Address;
import pl.sdacademy.hibernatesecond.entities.User;
import pl.sdacademy.hibernatesecond.repositories.UserRepository;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userRepository.addUser(user);
    }

    @GetMapping("/users/{id}")
    public User findOneUser(@PathVariable Long id) {
        return userRepository.findUserById(id);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userRepository.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteUser(id);
    }

    @PutMapping("/users/changepassword/{id}")
    public User changePassword(@PathVariable Long id, @RequestBody String newPassword) {
        return userRepository.changePassword(id, newPassword);
    }

    @GetMapping("/users/premium")
    public List<User> findPremiumUsers() {
        return userRepository.findPremiumUsers();
    }

    @GetMapping("/users/saldo/{saldo}")
    public List<User> findUsersWithSpecificSaldo(@PathVariable BigDecimal saldo) {
        return userRepository.findUsersWithSpecificSaldo(saldo);
    }

    @GetMapping("/users/city/{city}")
    public List<User> findUsersFromSpecificCity(@PathVariable String city) {
        return userRepository.findUsersFromSpecificCity(city);
    }

    @GetMapping("/users/email/{email}")
    public User findUsersByEmail(@PathVariable String email) {
        return userRepository.findUserByEmail(email);
    }

    @PutMapping("/users/update/{id}")
    public User findUsersByEmail(@PathVariable Long id, @RequestBody User user) {
        return userRepository.updateUserById(id, user);
    }

    @PutMapping("/users/mail/update/{id}")
    public User updateUserEmail(@PathVariable Long id, @RequestBody String newEmail) {
        return userRepository.updateUserEmail(id, newEmail);
    }

    @PutMapping("/users/topremium/{id}")
    public User changeUserToPremium(@PathVariable Long id) {
        return userRepository.changeUserToPremium(id);
    }

    @PutMapping("/users/address/update/{id}")
    public User updateUserAddress(@PathVariable Long id, @RequestBody Address newAddress) {
        return userRepository.updateUserAddress(id, newAddress);
    }

    @PutMapping("/users/saldo/increase/{id}")
    public User increaseSaldo(@PathVariable Long id, @RequestBody BigDecimal increase) {
        return userRepository.increaseSaldo(id, increase);
    }

    @PutMapping("/users/saldo/decrease/{id}")
    public User decreaseSaldo(@PathVariable Long id, @RequestBody BigDecimal decrease) {
        return userRepository.decreaseSaldo(id, decrease);
    }

    @DeleteMapping("/users/delete/{id}")
    public Boolean decreaseSaldo(@PathVariable Long id) {
        return userRepository.deleteUserById(id);
    }


}
