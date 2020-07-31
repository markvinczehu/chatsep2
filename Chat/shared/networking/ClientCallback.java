package Chat.shared.networking;

import Chat.shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote
{
  void sendMessageResult(PropertyChangeEvent event) throws RemoteException;
}
