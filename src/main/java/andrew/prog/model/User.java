package andrew.prog.model;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private LocalDateTime registerDate;

    public User ( String firstName, String lastName, String password, String email, LocalDateTime registerDate) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.registerDate = registerDate;
    }

    public User () {

    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public LocalDateTime getRegisterDate () {
        return registerDate;
    }

    public void setRegisterDate (LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString () {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}
