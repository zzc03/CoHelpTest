package hit.entity;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "table_user")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name="user_name")
    private String name;
    @Column(name="user_account")
    private String account;
    @Column(name="user_password")
    private String password;
    @Column(name="user_description")
    private String description;
    @Column(name="user_money")
    private Integer money;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public User() {
        this.money=0;
    }
    public User(Integer userId)
    {
        this.userId=userId;
        this.name = null;
        this.account = null;
        this.password = null;
        this.description = null;
        this.money = 0;
    }
    public User(String name) {
        this.name = name;
        this.account = null;
        this.password = null;
        this.description = null;
        this.money = 0;
    }


    public User(String name, String account) {
        this.name = name;
        this.account = account;
        this.password = null;
        this.description = null;
        this.money = 0;
    }

    public User(String name, String account, String password) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.description = null;
        this.money=0;
    }

    public User(String name, String account, String password, String description) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.description = description;
        this.money = 0;
    }

    public User(String name, String account, String password, String description, Integer money) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.description = description;
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", money=" + money +
                '}';
    }
}
