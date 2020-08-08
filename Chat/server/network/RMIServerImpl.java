package Chat.server.network;

import Chat.server.model.ServerModel;
import Chat.shared.networking.*;
import Chat.shared.transferobjects.Message;
import Chat.shared.transferobjects.PrivateMessage;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RMIServerImpl implements RMIServer
{
  private ServerModel serverModel;
  private List<CommonChatCallback> commonChatClientList;
  private CommonChatCallback commonChatCallback;
  private UserInfoCallback userInfoCallback;

  public RMIServerImpl(ServerModel serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModel = serverModel;
    commonChatClientList = new ArrayList<>();
    serverModel.addListener("UsersList", this::onUserList);
    serverModel.addListener("UserInfo", this::onUserInfo);
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", this);
  }

  @Override public boolean loginUser(String username, String password)
  {
    return serverModel.loginUser(username, password);
  }

  @Override public void sendMessage(String input) throws RemoteException
  {
    Message message = serverModel.sendMessage(input);
    for (CommonChatCallback client : commonChatClientList) {
      client.sendMessageResult(message);
    }
  }

  @Override public void registerUser(String un, String pw){
    serverModel.registerUser(un, pw);
  }

  @Override public void registerCommonChat(
      CommonChatCallback commonChatCallback)
  {
    System.out.println("arrived at server");
    commonChatClientList.add(commonChatCallback);
  }


  @Override public void editProfile(String un, String pw, String fn, String ln,
      String age, String pnumb, String email)
  {
    serverModel.editProfile(un, pw, fn, ln, age, pnumb, email);
  }

  @Override public void getUserList(CommonChatCallback commonChatCallback)
  {
    this.commonChatCallback = commonChatCallback;
    serverModel.getUserList();
    System.out.println("server network");
  }

  @Override public void onUserList(PropertyChangeEvent event)
  {
    try
    {
      commonChatCallback.sendUserList(event);
      System.out.println("server callback");
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public User getCurrentUser()
  {
    return serverModel.getCurrentUser();
  }

  @Override public void getUserInfo(String username)
      throws RemoteException
  {
    serverModel.getUserInfo(username);
  }

  @Override public void getInfo(UserInfoCallback callback) throws RemoteException
  {
    userInfoCallback = callback;
    serverModel.getInfo();
  }

  @Override public void onUserInfo(PropertyChangeEvent event)
  {
    try
    {
      userInfoCallback.sendUserInfo(event);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void sendPrivateMessage(int fromUser, int toUser, String message)
  {
    serverModel.sendPrivateMessage(fromUser, toUser, message);
  }

  @Override public int getToUserForPM() throws RemoteException
  {
    return serverModel.getToUserForPM();
  }
}
