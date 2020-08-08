package Chat.shared.networking;

import Chat.shared.transferobjects.Message;

import java.beans.PropertyChangeEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface RMIServer extends Remote
{
  boolean loginUser(String username, String password) throws RemoteException;
  void sendMessage(String input) throws RemoteException;
  void registerUser(String un, String pw) throws RemoteException, SQLException;
  void registerCommonChat(ClientCallback clientCallback) throws RemoteException;
  void editProfile (String un, String pw, String fn, String ln, String age, String pn, String pnumb, String email) throws RemoteException;
  void getUserList(ClientCallback clientCallback) throws RemoteException;
  void onUserList(PropertyChangeEvent propertyChangeEvent) throws RemoteException;
  User getCurrentUser() throws RemoteException;
}
