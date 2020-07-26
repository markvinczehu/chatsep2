package Chat.client.core;

import Chat.client.model.commonchat.CommonChatModel;
import Chat.client.model.commonchat.CommonChatModelManager;
import Chat.client.model.login.LoginModel;
import Chat.client.model.login.LoginModelManager;
import Chat.client.model.registration.RegistrationModel;
import Chat.client.model.registration.RegistrationModelManager;

public class ModelFactory
{
  private ClientFactory clientFactory;
  private LoginModel loginModel;
  private CommonChatModel commonChatModel;
  private RegistrationModel registrationModel;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
  }

  public LoginModel getLoginModel()
  {
    if(loginModel == null)
    {
      loginModel = new LoginModelManager(clientFactory.getLoginClient());
    }
    return loginModel;
  }

  public CommonChatModel getCommonChatModel()
  {
    if(commonChatModel == null)
    {
      commonChatModel = new CommonChatModelManager(clientFactory.getCommonChatClient());
    }
    return commonChatModel;
  }

  public RegistrationModel getRegistrationModel() {
    if (registrationModel == null) {
      //registrationModel = new RegistrationModelManager();
    }
    return registrationModel;
  }
}
