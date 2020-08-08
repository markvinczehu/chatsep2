package Chat.shared.transferobjects;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;
import java.util.TimeZone;

public class Message implements Serializable {

    private String username;
    private String msg;
    private String date;
    public Message(String username, String msg) {
        this.username = username;
        this.msg = msg;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        this.date = formatter.format(date);
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
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        this.date = formatter.format(date);
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return username + ": " + msg + " - " + date;
    }
}
