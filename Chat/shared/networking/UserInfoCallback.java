package Chat.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserInfoCallback extends Remote
{
  void sendUserInfo(UserInfo userInfo) throws RemoteException;
}
