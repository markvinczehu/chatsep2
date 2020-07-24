package Chat.client.model.login;

import Chat.client.network.Client;

public class LoginModelManager implements LoginModel
{
  private Client client;

  public LoginModelManager(Client client)
  {
    this.client = client;
    client.startClient();
  }
  @Override public void loginUser()
  {
    client.loginUser();
  }
}
