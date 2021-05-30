package hit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "table_message")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="message_id")
    private Integer id;
    @Column(name="message_type")
    private Integer type;
    @Column(name="send_id")
    private Integer sendid;
    @Column(name="receive_id")
    private Integer receiverid;
    @Column(name="is_read")
    private Integer isread;
    @Column(name="title")
    private String title;
    @Column(name="text")
    private String text;
    @Column(name="time")
    private String time;

    public Message() {
    }

    public Message(Integer id, Integer type, Integer sendid, Integer receiverid, Integer isread, String title, String text, String time) {
        this.id = id;
        this.type = type;
        this.sendid = sendid;
        this.receiverid = receiverid;
        this.isread = isread;
        this.title = title;
        this.text = text;
        this.time = time;
    }

    public Message(Integer type, Integer sendid, Integer receiverid, Integer isread, String title, String text, String time) {
        this.type = type;
        this.sendid = sendid;
        this.receiverid = receiverid;
        this.isread = isread;
        this.title = title;
        this.text = text;
        this.time = time;
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

    public Integer getSendid() {
        return sendid;
    }

    public void setSendid(Integer sendid) {
        this.sendid = sendid;
    }

    public Integer getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(Integer receiverid) {
        this.receiverid = receiverid;
    }

    public Integer getIsread() {
        return isread;
    }

    public void setIsread(Integer isread) {
        this.isread = isread;
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

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", type=" + type +
                ", sendid=" + sendid +
                ", receiverid=" + receiverid +
                ", isread=" + isread +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
