package Chat.client.model.privatechat;

import Chat.shared.transferobjects.PrivateMessage;
import Chat.shared.util.Subject;

import java.beans.PropertyChangeEvent;

public interface PrivateChatModel extends Subject {
    void sendMessage(PrivateMessage message);
    void onSendMessage(PropertyChangeEvent event);
  String getFromUserForPM();
  String getToUserForPM();
}
