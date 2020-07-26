package Chat.client.core;

import Chat.client.network.commonchat.CommonChatClient;
import Chat.client.network.commonchat.CommonChatClientImpl;
import Chat.client.network.login.LoginClient;
import Chat.client.network.login.LoginClientImpl;

public class ClientFactory
{
  private LoginClient loginClient;
  private CommonChatClient commonChatClient;

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
}
