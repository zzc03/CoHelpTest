package hit.entity;

public class ItemNeed {

    private Need need;
    private String userName;
    private String needState;

    public ItemNeed() {
    }

    public ItemNeed(Need need, String userName, String needState) {
        this.need = need;
        this.userName = userName;
        this.needState = needState;
    }

    public Need getNeed() {
        return need;
    }

    public void setNeed(Need need) {
        this.need = need;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNeedState() {
        return needState;
    }

    public void setNeedState(String needState) {
        this.needState = needState;
    }

    @Override
    public String toString() {
        return "ItemNeed{" +
                "need=" + need +
                ", userName='" + userName + '\'' +
                ", needState='" + needState + '\'' +
                '}';
    }
}