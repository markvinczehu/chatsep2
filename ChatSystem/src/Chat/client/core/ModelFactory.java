package Chat.client.core;

import Chat.client.model.login.LoginModel;
import Chat.client.model.login.LoginModelManager;
import Chat.client.network.Client;

public class ModelFactory
{
  private ClientFactory clientFactory;
  private LoginModel loginModel;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
  }

  public LoginModel getLoginModel()
  {
    if(loginModel == null)
    {
      loginModel = new LoginModelManager(clientFactory.getClient());
    }
    return loginModel;
  }
}
