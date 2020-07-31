package Chat.client.model.commonchat;

import Chat.shared.transferobjects.Message;
import Chat.shared.util.Subject;

import java.beans.PropertyChangeEvent;

public interface CommonChatModel extends Subject
{
  void sendMessage(String input);
  void onSendMessage(PropertyChangeEvent event);
}
