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

  @Override public void seeUserInfo(String username, String firstName,
      String lastName, String age, String profileName, String email,
      String phoneNumber)
  {
    userInfoClient.seeUserInfo(username, firstName, lastName, age, profileName, email, phoneNumber);
  }

  @Override public void onFriendRequest()
  {

  }

  @Override public void onPrivateConversation()
  {

  }
}
