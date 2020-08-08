package Chat.client.model.userinfo;

import Chat.shared.util.Subject;

import java.beans.PropertyChangeEvent;

public interface UserInfoModel extends Subject
{
  void getInfo(String username);
  void onFriendRequest();
  void onPrivateConversation();
  void onUserInfo(PropertyChangeEvent event);
}
