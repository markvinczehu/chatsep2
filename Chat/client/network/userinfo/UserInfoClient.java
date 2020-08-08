package Chat.client.network.userinfo;

import Chat.client.network.Client;
import Chat.shared.networking.UserInfo;
import Chat.shared.networking.UserInfoCallback;

public interface UserInfoClient extends Client
{
  void getInfo();
}
