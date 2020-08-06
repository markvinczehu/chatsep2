package Chat.client.network.userinfo;

import Chat.client.network.Client;

public interface UserInfoClient extends Client
{
  void seeUserInfo(String username, String firstName, String lastName, String age, String profileName, String email, String phoneNumber);
}
