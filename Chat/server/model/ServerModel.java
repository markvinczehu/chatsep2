package Chat.server.model;

public interface ServerModel
{
  void loginUser(String username);
  void sendMessage();
  void registerUser(String un, String pw);
}
