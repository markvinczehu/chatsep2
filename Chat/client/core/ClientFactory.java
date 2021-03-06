package Chat.client.core;

import Chat.client.network.commonchat.CommonChatClient;
import Chat.client.network.commonchat.CommonChatClientImpl;
import Chat.client.network.login.LoginClient;
import Chat.client.network.login.LoginClientImpl;
import Chat.client.network.privatechat.PrivateChatClient;
import Chat.client.network.registration.RegistrationClient;
import Chat.client.network.registration.RegistrationClientImpl;
import Chat.client.network.profile.ProfileClient;
import Chat.client.network.profile.ProfileClientImpl;
import Chat.client.network.userinfo.UserInfoClient;
import Chat.client.network.userinfo.UserInfoClientImpl;
import Chat.client.network.privatechat.PrivateChatClient;
import Chat.client.network.privatechat.PrivateChatClientImpl;

public class ClientFactory
{
  private LoginClient loginClient;
  private CommonChatClient commonChatClient;
  private RegistrationClient registrationClient;
  private ProfileClient profileClient;
  private UserInfoClient userInfoClient;
  private PrivateChatClient privateChatClient;

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

  public UserInfoClient getUserInfoClient()
  {
    if (userInfoClient == null)
    {
      userInfoClient = new UserInfoClientImpl();
    }
    return userInfoClient;
  }

  public PrivateChatClient getPrivateChatClient() {
    if(privateChatClient == null) {
      privateChatClient = new PrivateChatClientImpl();
    }
    return privateChatClient;
  }
}
