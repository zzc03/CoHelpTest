package hit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "table_need")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Need {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="need_id")
    private Integer need_id;
    @Column(name="need_title")
    private String title;
    @Column(name="need_text")
    private String text;
    @Column(name="need_time")
    private String time;
    @Column(name="need_state")
    private String state;
    @Column(name="need_reward")
    private Integer reward;
    @Column(name="need_user_id")
    private Integer userid;

    public Need() {
    }
    public Need(Integer id) {
        this.need_id=id;
    }




    public Need(String title, String text, String time, String state, Integer reward, Integer userid) {
        this.title = title;
        this.text = text;
        this.time = time;
        this.state = state;
        this.reward = reward;
        this.userid = userid;
    }

    public Integer getNeedid() {
        return need_id;
    }

    public void setNeedid(Integer needid) {
        this.need_id = needid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getNeed_id() {
        return need_id;
    }

    public void setNeed_id(Integer need_id) {
        this.need_id = need_id;
    }

    public Integer getReward() {
        return reward;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Need{" +
                "need_id=" + need_id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", state='" + state + '\'' +
                ", reward=" + reward +
                ", userid=" + userid +
                '}';
    }
}
