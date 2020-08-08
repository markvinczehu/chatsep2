package Chat.shared.networking;

import java.beans.PropertyChangeEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserInfoCallback extends Remote
{
  void sendUserInfo(PropertyChangeEvent event) throws RemoteException;
}
