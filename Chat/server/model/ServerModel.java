package Chat.server.model;

import Chat.shared.transferobjects.Message;
import Chat.shared.util.Subject;
import javafx.beans.property.ListProperty;

public interface ServerModel extends Subject
{
  void loginUser(String username, String password);
  void sendMessage(Message message);
  void registerUser(String un, String pw);
  void showActiveUsers(ListProperty activeUsers);
  void editProfile(String un, String pw, String fn, String ln, String age, String pn, String pnumb, String email);
}
