package hit.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "table_picture")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="picture_id")
    private Integer pictureid;
    @Column(name="result_id")
    private Integer resultid;
    @Column(name="picture")
    private byte[] picture;

    public Picture() {
    }

    public Picture(Integer resultid, byte[] picture) {
        this.resultid = resultid;
        this.picture = picture;
    }

    public Integer getPictureid() {
        return pictureid;
    }

    public void setPictureid(Integer pictureid) {
        this.pictureid = pictureid;
    }

    public Integer getResultid() {
        return resultid;
    }

    public void setResultid(Integer resultid) {
        this.resultid = resultid;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pictureid=" + pictureid +
                ", resultid=" + resultid +
                ", picture=" + Arrays.toString(picture) +
                '}';
    }
}
