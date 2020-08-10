package Chat.client.network.privatechat;

import Chat.client.network.Client;
import Chat.shared.networking.User;
import Chat.shared.networking.UserInfo;
import Chat.shared.transferobjects.Message;
import Chat.shared.transferobjects.PrivateMessage;

import java.rmi.RemoteException;
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
