package Chat.shared.networking;

import Chat.shared.transferobjects.Message;

import java.beans.PropertyChangeEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PrivateChatCallback extends Remote
{
  void sendMessageResult(Message message) throws RemoteException;
  void sendUserList(PropertyChangeEvent event) throws RemoteException;
}
