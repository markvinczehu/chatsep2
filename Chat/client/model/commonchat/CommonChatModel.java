package Chat.client.model.commonchat;

import Chat.shared.networking.UserInfo;
import Chat.shared.transferobjects.Message;
import Chat.shared.util.Subject;

import java.beans.PropertyChangeEvent;

public interface CommonChatModel extends Subject
{
  void sendMessage(Message message);
  void onSendMessage(PropertyChangeEvent event);
  void getUserList();
  void onUserList(PropertyChangeEvent event);
  UserInfo getCurrentUser();
  void getUserInfo(String username);
  boolean getGuestUser();
  void logoutUser();
}
