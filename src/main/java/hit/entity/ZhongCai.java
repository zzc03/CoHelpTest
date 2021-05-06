package hit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "table_zhongcai")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ZhongCai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="zc_id")
    private Integer id;
    @Column(name="zc_type")
    private Integer type;
    @Column(name="zc_objectid")
    private Integer applyid;
    @Column(name="zc_reaon")
    private String reason;
    @Column(name="zc_applyuserid")
    private Integer applyuserid;
    @Column(name="zc_applytime")
    private String time;
    @Column(name="zc_solveuserid")
    private Integer solveuserid;
    @Column(name="zc_solvetime")
    private String solvetime;
    @Column(name="zc_solveview")
    private String solveview;
    @Column(name="zc_solveviewtext")
    private String solveviewtext;

    public ZhongCai() {
    }

    public ZhongCai(Integer type, Integer applyid, String reason, Integer applyuserid, String time, Integer solveuserid, String solvetime, String solveview, String solveviewtext) {
        this.type = type;
        this.applyid = applyid;
        this.reason = reason;
        this.applyuserid = applyuserid;
        this.time = time;
        this.solveuserid = solveuserid;
        this.solvetime = solvetime;
        this.solveview = solveview;
        this.solveviewtext = solveviewtext;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getApplyuserid() {
        return applyuserid;
    }

    public void setApplyuserid(Integer applyuserid) {
        this.applyuserid = applyuserid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getSolveuserid() {
        return solveuserid;
    }

    public void setSolveuserid(Integer solveuserid) {
        this.solveuserid = solveuserid;
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

    public String getSolveviewtext() {
        return solveviewtext;
    }

    public void setSolveviewtext(String solveviewtext) {
        this.solveviewtext = solveviewtext;
    }
}
