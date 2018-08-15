package api.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    private String username;

    private String password;
    private char isDeleted;
    //the username since the username is actually the email
    private String name;

    public User(){
        this.isDeleted = '0';
    }

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.isDeleted = '0';
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getIsDeleted() {
        return isDeleted;
    }

    public void Delete(char isDeleted) {
        this.isDeleted = '1';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
