package Chat.client.model.commonchat;

import Chat.shared.networking.User;
import Chat.shared.util.Subject;

import java.beans.PropertyChangeEvent;

public interface CommonChatModel extends Subject
{
  void sendMessage(String input);
  void onSendMessage(PropertyChangeEvent event);
  void getUserList();
  void onActiveUsers(PropertyChangeEvent event);
  User getCurrentUser();
}
