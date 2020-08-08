package Chat.client.model.userinfo;

import Chat.client.network.userinfo.UserInfoClient;

public class UserInfoModelManager implements UserInfoModel
{
  private UserInfoClient userInfoClient;

  public UserInfoModelManager (UserInfoClient userInfoClient)
  {
    this.userInfoClient=userInfoClient;
    userInfoClient.startClient();
  }

  @Override public void getInfo(String username)
  {
    userInfoClient.getInfo(username);
  }

  @Override public void onFriendRequest()
  {

  }

  @Override public void onPrivateConversation()
  {

  }
}
