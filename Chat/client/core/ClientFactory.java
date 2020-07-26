package Chat.client.core;

import Chat.client.network.commonchat.CommonChatClient;
import Chat.client.network.commonchat.CommonChatClientImpl;
import Chat.client.network.login.LoginClient;
import Chat.client.network.login.LoginClientImpl;
import Chat.client.network.registration.RegistrationClient;
import Chat.client.network.registration.RegistrationClientImpl;

public class ClientFactory
{
  private LoginClient loginClient;
  private CommonChatClient commonChatClient;
  private RegistrationClient registrationClient;

  public LoginClient getLoginClient()
  {
    if(loginClient == null) {
      loginClient = new LoginClientImpl();
    }
    return loginClient;
  }

  public CommonChatClient getCommonChatClient()
  {
    if(commonChatClient == null) {
      commonChatClient = new CommonChatClientImpl();
    }
    return commonChatClient;
  }
  public RegistrationClientImpl getRegistrationClient()
  {
    if (registrationClient == null) {
      registrationClient = new RegistrationClientImpl();
    }
    //For some reason it requires me to cast the RegistrationClientImpl class into the registrationClient, not sure why - Dimitrios
    return (RegistrationClientImpl) registrationClient;
  }
}
