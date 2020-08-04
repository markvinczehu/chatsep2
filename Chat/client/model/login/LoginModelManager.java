package Chat.client.model.login;

import Chat.client.network.login.LoginClient;

public class LoginModelManager implements LoginModel
{
  private LoginClient loginClient;

  public LoginModelManager(LoginClient client)
  {
    this.loginClient = client;
    loginClient.startClient();
  }

  @Override public void loginUser(String username, String password)
  {
    loginClient.loginUser(username,password);
  }
}
