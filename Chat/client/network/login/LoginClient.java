package Chat.client.network.login;

import Chat.client.network.Client;

public interface LoginClient extends Client
{
  boolean loginUser(String username, String password);
  void setGuestUser();
}
