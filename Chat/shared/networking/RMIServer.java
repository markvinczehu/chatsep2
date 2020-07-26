package Chat.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote
{
  void loginUser(String username) throws RemoteException;
  void sendMessage() throws RemoteException;
  void registerUser(String un, String pw);
}
