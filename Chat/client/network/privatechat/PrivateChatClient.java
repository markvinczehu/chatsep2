package Chat.client.network.privatechat;

import Chat.client.network.Client;
import Chat.shared.networking.User;
import Chat.shared.transferobjects.Message;

import java.rmi.RemoteException;

public interface PrivateChatClient extends Client {
    User getCurrentUser();
    void startClient();
    void sendMessage(Message message) throws RemoteException;
}
