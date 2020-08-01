package Chat.client.core;

import Chat.client.network.commonchat.CommonChatClient;
import Chat.client.network.commonchat.CommonChatClientImpl;
import Chat.client.network.login.LoginClient;
import Chat.client.network.login.LoginClientImpl;
import Chat.client.network.registration.RegistrationClient;
import Chat.client.network.registration.RegistrationClientImpl;
import Chat.client.network.profile.ProfileClient;
import Chat.client.network.profile.ProfileClientImpl;

public class ClientFactory
{
  private LoginClient loginClient;
  private CommonChatClient commonChatClient;
  private RegistrationClient registrationClient;
  private ProfileClient profileClient;

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
  public RegistrationClient getRegistrationClient()
  {
    if (registrationClient == null) {
      registrationClient = new RegistrationClientImpl();
    }
    return registrationClient;
  }

  public ProfileClient getProfileClient()
  {
    if(profileClient == null) {
      profileClient = new ProfileClientImpl();
    }
    return profileClient;
  }
}
