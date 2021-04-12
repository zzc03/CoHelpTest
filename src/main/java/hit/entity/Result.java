package hit.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "table_result")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="result_id")
    private Integer resultId;
    @Column(name="need_id")
    private Integer needid;
    @Column(name="need_acceptuserid")
    private Integer acceptuserid;
    @Column(name="need_state")
    private String state;
    @Column(name="need_accepttime")
    private String accepttime;
    @Column(name="need_accepttext")
    private String accepttext;
    @Column(name="need_acceptpicturenum")
    private Integer picturenum;
    @Column(name="result_reward")
    private Integer reward;

    public Result() {
    }

    public Result(Integer needid, Integer acceptuserid, String state, String accepttime, String accepttext, Integer picture, Integer reward) {
        this.needid = needid;
        this.acceptuserid = acceptuserid;
        this.state = state;
        this.accepttime = accepttime;
        this.accepttext = accepttext;
        this.picturenum = picture;
        this.reward = reward;
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public Integer getNeedid() {
        return needid;
    }

    public void setNeedid(Integer needid) {
        this.needid = needid;
    }

    public Integer getAcceptuserid() {
        return acceptuserid;
    }

    public void setAcceptuserid(Integer acceptuserid) {
        this.acceptuserid = acceptuserid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAccepttime() {
        return accepttime;
    }

    public void setAccepttime(String accepttime) {
        this.accepttime = accepttime;
    }

    public String getAccepttext() {
        return accepttext;
    }

    public void setAccepttext(String accepttext) {
        this.accepttext = accepttext;
    }

    public Integer getPicture() {
        return picturenum;
    }

    public void setPicture(Integer picture) {
        this.picturenum = picture;
    }

    public Integer getReward() {
        return reward;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultId=" + resultId +
                ", needid=" + needid +
                ", acceptuserid=" + acceptuserid +
                ", state='" + state + '\'' +
                ", accepttime='" + accepttime + '\'' +
                ", accepttext='" + accepttext + '\'' +
                ", picture=" + picturenum +
                ", reward=" + reward +
                '}';
    }
}
