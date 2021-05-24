package hit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "table_register")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="applyid")
    private Integer applyid;
    @Column(name="account")
    private String account;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="stuid")
    private String stuid;
    @Column(name="icon")
    private String icon;
    @Column(name="state")
    private String state;
    @Column(name="solverid")
    private Integer solverid;
    @Column(name="solvetime")
    private String solvetime;
    @Column(name="solveview")
    private String solveview;
    @Column(name="solvetext")
    private String solvetext;

    public Register() {
    }

    public Register(String account, String password, String name, String stuid, String icon, String state) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.stuid = stuid;
        this.icon = icon;
        this.state = state;
    }

    public Register(String account, String password, String name, String stuid, String icon, String state, Integer solverid, String solvetime, String solveview, String solvetext) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.stuid = stuid;
        this.icon = icon;
        this.state = state;
        this.solverid = solverid;
        this.solvetime = solvetime;
        this.solveview = solveview;
        this.solvetext = solvetext;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
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

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSolverid() {
        return solverid;
    }

    public void setSolverid(Integer solverid) {
        this.solverid = solverid;
    }

    public String getSolvetime() {
        return solvetime;
    }

    public void setSolvetime(String solvetime) {
        this.solvetime = solvetime;
    }

    public String getSolveview() {
        return solveview;
    }

    public void setSolveview(String solveview) {
        this.solveview = solveview;
    }

    public String getSolvetext() {
        return solvetext;
    }

    public void setSolvetext(String solvetext) {
        this.solvetext = solvetext;
    }

    @Override
    public String toString() {
        return "Register{" +
                "applyid=" + applyid +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", stuid='" + stuid + '\'' +
                ", icon='" + icon + '\'' +
                ", solverid=" + solverid +
                ", solvetime='" + solvetime + '\'' +
                ", solveview='" + solveview + '\'' +
                ", solvetext='" + solvetext + '\'' +
                '}';
    }
}
