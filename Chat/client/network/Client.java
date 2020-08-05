package Chat.client.network;

import Chat.shared.util.Subject;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Subject
{
  void startClient();
}
