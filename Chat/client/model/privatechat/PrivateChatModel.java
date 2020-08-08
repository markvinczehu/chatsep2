package Chat.client.model.privatechat;

import Chat.shared.transferobjects.PrivateMessage;
import Chat.shared.util.Subject;

import java.beans.PropertyChangeEvent;

public interface PrivateChatModel extends Subject {
    void sendMessage(int fromUser, int toUser, String message);
    void onSendMessage(PropertyChangeEvent event);
  int getFromUserForPM();
  int getToUserForPM();
}
