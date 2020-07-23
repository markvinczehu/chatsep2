package Chat.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote
{
  void message(String str, ClientCallback clientCallback) throws
      RemoteException;
}
