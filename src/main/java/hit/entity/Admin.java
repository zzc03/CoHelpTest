package hit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "table_admin")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="account")
    private String account;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;

    public Admin() {
    }

    public Admin(Integer id, String account, String password, String name) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
