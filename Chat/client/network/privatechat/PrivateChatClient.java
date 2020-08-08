package Chat.client.network.privatechat;

import Chat.client.network.Client;
import Chat.shared.networking.User;
import Chat.shared.transferobjects.Message;
import Chat.shared.transferobjects.PrivateMessage;

import java.rmi.RemoteException;

public interface PrivateChatClient extends Client {
    String getFromUserForPM();
    String getToUserForPM();
    void startClient();
    void sendMessage(PrivateMessage message);
}
