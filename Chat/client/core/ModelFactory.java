package Chat.client.core;

import Chat.client.model.login.LoginModel;
import Chat.client.model.login.LoginModelManager;
import Chat.client.model.registration.RegistrationModel;
import Chat.client.model.registration.RegistrationModelManager;

public class ModelFactory
{
  private ClientFactory clientFactory;
  private LoginModel loginModel;
  private RegistrationModel registrationModel;

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
  public RegistrationModel getRegistrationModel() {
    if (registrationModel == null) {
      registrationModel = new RegistrationModelManager(clientFactory.getClient());
    }
    return registrationModel;
  }
}
