package Chat.shared.networking;

import Chat.client.network.commonchat.CommonChatClient;
import Chat.shared.transferobjects.Message;

import java.beans.PropertyChangeEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote
{
  void loginUser(String username, String password) throws RemoteException;
  void sendMessage(Message message, ClientCallback clientCallback) throws RemoteException;
  void registerUser(String un, String pw) throws RemoteException;
  void registerCommonChat(CommonChatClient commonChatClient) throws RemoteException;
  void onSendMessage(PropertyChangeEvent propertyChangeEvent) throws RemoteException;
  void editProfile (String un, String pw, String fn, String ln, String age, String pn, String pnumb, String email) throws RemoteException;
}
