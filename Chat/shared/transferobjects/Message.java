package Chat.shared.transferobjects;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

public class Message implements Serializable {

    private String username;
    private String msg;
    private Date date;

    public Message(String username, String msg) {
        this.date = new Date();
        this.username = username;
        this.msg = msg;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "username='" + username + '\'' +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }
}

