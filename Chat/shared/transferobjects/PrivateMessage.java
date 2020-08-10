package Chat.shared.transferobjects;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrivateMessage implements Serializable
{
  private int fromUser;
  private int toUser;
  private String msg;
  private String date;

  public PrivateMessage(int fromUser, int toUser, String msg) {
    this.fromUser = fromUser;
    this.toUser = toUser;
    this.msg = msg;
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    this.date = formatter.format(date);
  }

  public PrivateMessage(int fromUser, int toUser, String msg, String date)
  {
    this.fromUser = fromUser;
    this.toUser = toUser;
    this.msg = msg;
    this.date = date;
  }
  public void setFromUser(int fromUser) {
    this.fromUser = fromUser;
  }
  public int getFromUser() {
    return fromUser;
  }

  public void setToUser(int toUser) {
    this.toUser = toUser;
  }
  public int getToUser() {
    return toUser;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }

  public void setDate(Date date) {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
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
