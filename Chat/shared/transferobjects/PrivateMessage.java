package Chat.shared.transferobjects;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrivateMessage implements Serializable
{
  private String fromUser;
  private String toUser;
  private String msg;
  private String date;
  public PrivateMessage(String fromUser, String toUser, String msg) {
    this.fromUser = fromUser;
    this.toUser = toUser;
    this.msg = msg;
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
    this.date = formatter.format(date);
  }

  public void setFromUser(String fromUser) {
    this.fromUser = fromUser;
  }
  public String getFromUser() {
    return fromUser;
  }

  public void setToUser(String toUser) {
    this.toUser = toUser;
  }
  public String getToUser() {
    return toUser;
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
    return date + " - " + fromUser + ": " + msg;
  }
}
