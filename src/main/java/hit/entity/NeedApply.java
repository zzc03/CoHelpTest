package hit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "table_needapply")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class NeedApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="applyid")
    Integer applyid;
    @Column(name="applyuserid")
    Integer applyuserid;
    @Column(name="needtitle")
    String needtitle;
    @Column(name="needtext")
    String needtext;
    @Column(name="needtime")
    String needtime;
    @Column(name="needreward")
    Integer needreward;
    @Column(name="applystate")
    String applystate;
    @Column(name="solveuserid")
    Integer solveuserid;
    @Column(name="solvetime")
    String solovetime;
    @Column(name="solveview")
    String solveview;

    public NeedApply() {
    }

    public NeedApply(Integer applyuserid,  String needtitle, String needtext, String needtime, Integer needreward, String applystate, Integer solveuserid, String solovetime, String solveview) {
        this.applyuserid = applyuserid;

        this.needtitle = needtitle;
        this.needtext = needtext;
        this.needtime = needtime;
        this.needreward = needreward;
        this.applystate = applystate;
        this.solveuserid = solveuserid;
        this.solovetime = solovetime;
        this.solveview = solveview;
    }

    public NeedApply(Integer applyid, Integer applyuserid,  String needtitle, String needtext, String needtime, Integer needreward, String applystate, Integer solveuserid, String solovetime, String solveview) {
        this.applyid = applyid;
        this.applyuserid = applyuserid;

        this.needtitle = needtitle;
        this.needtext = needtext;
        this.needtime = needtime;
        this.needreward = needreward;
        this.applystate = applystate;
        this.solveuserid = solveuserid;
        this.solovetime = solovetime;
        this.solveview = solveview;
    }

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public Integer getApplyuserid() {
        return applyuserid;
    }

    public void setApplyuserid(Integer applyuserid) {
        this.applyuserid = applyuserid;
    }



    public String getNeedtitle() {
        return needtitle;
    }

    public void setNeedtitle(String needtitle) {
        this.needtitle = needtitle;
    }

    public String getNeedtext() {
        return needtext;
    }

    public void setNeedtext(String needtext) {
        this.needtext = needtext;
    }

    public String getNeedtime() {
        return needtime;
    }

    public void setNeedtime(String needtime) {
        this.needtime = needtime;
    }

    public Integer getNeedreward() {
        return needreward;
    }

    public void setNeedreward(Integer needreward) {
        this.needreward = needreward;
    }

    public String getApplystate() {
        return applystate;
    }

    public void setApplystate(String applystate) {
        this.applystate = applystate;
    }

    public Integer getSolveuserid() {
        return solveuserid;
    }

    public void setSolveuserid(Integer solveuserid) {
        this.solveuserid = solveuserid;
    }

    public String getSolovetime() {
        return solovetime;
    }

    public void setSolovetime(String solovetime) {
        this.solovetime = solovetime;
    }

    public String getSolveview() {
        return solveview;
    }

    public void setSolveview(String solveview) {
        this.solveview = solveview;
    }

    @Override
    public String toString() {
        return "NeedApply{" +
                "applyid=" + applyid +
                ", applyuserid=" + applyuserid +
                ", needtitle='" + needtitle + '\'' +
                ", needtext='" + needtext + '\'' +
                ", needtime='" + needtime + '\'' +
                ", needreward=" + needreward +
                ", applystate='" + applystate + '\'' +
                ", solveuserid=" + solveuserid +
                ", solovetime='" + solovetime + '\'' +
                ", solveview='" + solveview + '\'' +
                '}';
    }
}

