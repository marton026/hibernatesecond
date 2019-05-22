package pl.sdacademy.hibernatesecond.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.hibernatesecond.entities.Address;
import pl.sdacademy.hibernatesecond.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<User> findAllUsers() {
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        return users;
    }

    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public User findUserById(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Transactional
    public void updateUser(Long id, User newUserData) {
        User userFromDb = entityManager.find(User.class, id);
        userFromDb.setEmail(newUserData.getEmail());
        userFromDb.setPassword(newUserData.getPassword());
        userFromDb.setCredits(newUserData.getCredits());
        userFromDb.setPremium(newUserData.getPremium());

        entityManager.merge(userFromDb);
    }

    @Transactional
    public void deleteUser(Long id) {
        User userFromDb = entityManager.find(User.class, id);
        entityManager.remove(userFromDb);
    }

    @Transactional
    public User changePassword(Long id, String newPassword) {
        User user = entityManager.find(User.class, id);
        user.setPassword(newPassword);

        User mergedUser = entityManager.merge(user);
        return mergedUser;
    }

    @Transactional
    public List<User> findPremiumUsers() {
        List<User> users = entityManager.createQuery("from User u where u.premium = true", User.class).getResultList();
        return users;
    }

    @Transactional
    public List<User> findUsersWithSpecificSaldo(BigDecimal saldo) {
        List<User> users = entityManager.createQuery("from User u where u.saldo = :specificSaldo", User.class)
                .setParameter("specificSaldo", saldo)
                .getResultList();

        return users;
    }

    @Transactional
    public List<User> findUsersFromSpecificCity(String cityName) {
        List<User> users = entityManager.createQuery("from User u where u.address.city = :city", User.class)
                .setParameter("city", cityName)
                .getResultList();

        return users;
    }

    @Transactional
    public User findUserByEmail(String email) {
        User users = entityManager.createQuery("from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();

        return users;
    }

    @Transactional
    public User updateUserById(Long id, User newUserData) {
        User userFromDb = findUserById(id);
        userFromDb.setEmail(newUserData.getEmail());
        userFromDb.setPassword(newUserData.getPassword());
        userFromDb.setAddress(newUserData.getAddress());
        userFromDb.setPremium(newUserData.getPremium());
        userFromDb.setSaldo(newUserData.getSaldo());

        User mergedUser = entityManager.merge(userFromDb);
        return mergedUser;
    }

    @Transactional
    public User updateUserEmail(Long id, String newEmail) {
        User userFromDb = findUserById(id);
        userFromDb.setEmail(newEmail);

        User mergedUser = entityManager.merge(userFromDb);
        return mergedUser;
    }

    @Transactional
    public User changeUserToPremium(Long userId) {
        User userFromDb = findUserById(userId);
        userFromDb.setPremium(true);

        User mergedUser = entityManager.merge(userFromDb);
        return mergedUser;
    }

    @Transactional
    public User updateUserAddress(Long id, Address newAddress) {
        User userFromDb = findUserById(id);
        userFromDb.setAddress(newAddress);

        User mergedUser = entityManager.merge(userFromDb);
        return mergedUser;
    }

    @Transactional
    public User increaseSaldo(Long id, BigDecimal increase) {
        User userFromDb = findUserById(id);
        BigDecimal currentSaldo = userFromDb.getSaldo();
        userFromDb.setSaldo(currentSaldo.add(increase));

        User mergedUser = entityManager.merge(userFromDb);
        return mergedUser;
    }

    @Transactional
    public User decreaseSaldo(Long id, BigDecimal decrease) {
        User userFromDb = findUserById(id);
        BigDecimal currentSaldo = userFromDb.getSaldo();
        userFromDb.setSaldo(currentSaldo.subtract(decrease));

        User mergedUser = entityManager.merge(userFromDb);
        return mergedUser;
    }

    @Transactional
    public Boolean deleteUserById(Long id) {
        User userFromDb = findUserById(id);
        if (userFromDb != null) {
            entityManager.remove(userFromDb);
            return true;
        }

        return false;
    }


}
