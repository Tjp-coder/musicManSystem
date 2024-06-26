package bean;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer gender = -1;
    private String phone;
    private String email;


    public User() {

    }

    public User(String username, String password, String name, Integer gender, String phone, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }
}

