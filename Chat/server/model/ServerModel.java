package Chat.server.model;

import javafx.beans.property.ListProperty;

public interface ServerModel
{
  void loginUser(String username);
  void sendMessage();
  void registerUser(String un, String pw);
  void showActiveUsers(ListProperty activeUsers);
}
