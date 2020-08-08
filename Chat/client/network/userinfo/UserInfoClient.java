package Chat.client.network.userinfo;

import Chat.client.network.Client;
import Chat.shared.networking.UserInfo;

public interface UserInfoClient extends Client
{
  UserInfo getInfo(String username);
}
