package Chat.client.model.userinfo;

public interface UserInfoModel
{
  void seeUserInfo(String username, String firstName, String lastName, String age, String profileName, String email, String phoneNumber);
  void onFriendRequest();
  void onPrivateConversation();
}
