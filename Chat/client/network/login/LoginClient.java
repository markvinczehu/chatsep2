package Chat.client.network.login;

import Chat.client.network.Client;

public interface LoginClient extends Client
{
  void loginUser(String username, String password);
}
