package Chat.client.model.userinfo;

public interface UserInfoModel
{
  void getInfo(String username);
  void onFriendRequest();
  void onPrivateConversation();
}
