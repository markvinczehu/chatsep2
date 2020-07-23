package Chat.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote
{
  void messageResult (String result) throws RemoteException;
}
