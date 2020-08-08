package Chat.server.model;

import Chat.shared.networking.User;
import Chat.shared.networking.UserInfo;
import Chat.shared.transferobjects.Message;
import Chat.shared.transferobjects.PrivateMessage;
import Chat.shared.util.Subject;
import javafx.beans.property.ListProperty;
import javafx.beans.property.StringProperty;

import java.sql.SQLException;

public interface ServerModel extends Subject
{
  boolean loginUser(String username, String password);
  void registerUser(String un, String pw);
  void editProfile(String un, String pw, String fn, String ln, String age, String pnumb, String email);
  void getUserList();
  User getCurrentUser();
  Message sendMessage(String input);
  void getUserInfo(String username);
  void getInfo();
  void sendPrivateMessage(PrivateMessage message);
  String getToUserForPM();
}
