package Chat.client.model.privatechat;

import Chat.shared.transferobjects.UserInfo;
import Chat.shared.transferobjects.PrivateMessage;
import Chat.shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public interface PrivateChatModel extends Subject {
    void sendMessage(PrivateMessage privateMessage);
    void onSendMessage(PropertyChangeEvent event);
  int getFromUserForPM();
  int getToUserForPM();
  ArrayList<PrivateMessage> getMessageLog();
  UserInfo getCurrentUser();
  UserInfo getToUser();
}
