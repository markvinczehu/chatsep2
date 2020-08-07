package Chat.server.model;

import Chat.shared.networking.User;
import Chat.shared.transferobjects.Message;
import Chat.shared.util.Subject;
import javafx.beans.property.ListProperty;

import java.sql.SQLException;

public interface ServerModel extends Subject
{
  boolean loginUser(String username, String password);
  void registerUser(String un, String pw);
  void editProfile(String un, String pw, String fn, String ln, String age, String pn, String pnumb, String email);
  void getUserList();
  User getCurrentUser();
}
