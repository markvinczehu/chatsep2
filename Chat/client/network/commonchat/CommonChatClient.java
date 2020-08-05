package Chat.client.network.commonchat;

import Chat.client.network.Client;
import Chat.shared.networking.ClientCallback;
import Chat.shared.networking.User;
import Chat.shared.transferobjects.Message;


import java.rmi.RemoteException;

public interface CommonChatClient extends Client
{
  void sendMessage(Message message);
  void getUserList();
  User getCurrentUser();
}
