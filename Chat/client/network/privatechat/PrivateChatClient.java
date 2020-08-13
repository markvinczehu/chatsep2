package Chat.client.network.privatechat;

import Chat.client.network.Client;
import Chat.shared.transferobjects.UserInfo;
import Chat.shared.transferobjects.PrivateMessage;

import java.util.ArrayList;

public interface PrivateChatClient extends Client {
    int getFromUserForPM();
    int getToUserForPM();
    void startClient();
    void sendMessage(PrivateMessage privateMessage);
    ArrayList<PrivateMessage> getMessageLog();
    UserInfo getCurrentUser();
    UserInfo getToUser();
}
