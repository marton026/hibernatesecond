package pl.sdacademy.hibernatesecond.entities;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstnames")
    private String firstName;

    @Column(name = "lastnames")
    private String lastName;

    @Column(name = "logins")
    //@UniqueElements
    private String login;

    @Column(name = "passwords")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_carts_id",referencedColumnName = "id")
    private ShoppingCart shoppingCart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
