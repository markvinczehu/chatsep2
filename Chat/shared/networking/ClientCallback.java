package Chat.shared.networking;

import Chat.client.network.commonchat.CommonChatClient;
import Chat.shared.transferobjects.Message;
import Chat.shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote
{
  void sendMessageResult(Message message) throws RemoteException;
  void sendActiveUsers(PropertyChangeEvent event) throws RemoteException;
}
