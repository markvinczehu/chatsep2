package Chat.shared.networking;

import Chat.shared.transferobjects.Message;
import Chat.shared.transferobjects.PrivateMessage;
import Chat.shared.transferobjects.UserInfo;

import java.beans.PropertyChangeEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RMIServer extends Remote
{
  boolean loginUser(String username, String password) throws RemoteException;
  void sendMessage(Message message) throws RemoteException;
  void registerUser(String un, String pw) throws RemoteException, SQLException;
  void registerCommonChat(CommonChatCallback commonChatCallback) throws RemoteException;
  void editProfile (String un, String pw, String fn, String ln, String age, String pnumb, String email) throws RemoteException;
  void getUserList(CommonChatCallback commonChatCallback) throws RemoteException;
  void onUserList(PropertyChangeEvent propertyChangeEvent) throws RemoteException;
  UserInfo getCurrentUser() throws RemoteException;
  void getUserInfo(String username) throws RemoteException;
  void getInfo(UserInfoCallback callback) throws RemoteException;
  void onUserInfo(PropertyChangeEvent event) throws RemoteException;
  void sendPrivateMessage(PrivateMessage privateMessage) throws RemoteException;
  int getToUserForPM() throws RemoteException;
  void setGuestUser() throws  RemoteException;
  boolean getGuestUser() throws RemoteException;
  ArrayList<PrivateMessage> getMessageLog() throws RemoteException;
  UserInfo getToUser() throws RemoteException;
  void logoutUser() throws RemoteException;
}
