package pl.sdacademy.hibernatesecond.jdbc;

public class JdbcUser {

    private int id;
    private String email;
    private String password;
    private Double credits;
    private Boolean premium;

    public JdbcUser() {
    }

    public JdbcUser(String email, String password, Double credits, Boolean premium) {
        this.email = email;
        this.password = password;
        this.credits = credits;
        this.premium = premium;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }
}
