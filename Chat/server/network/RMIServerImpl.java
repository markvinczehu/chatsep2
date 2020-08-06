package Chat.server.network;

import Chat.server.model.ServerModel;
import Chat.shared.networking.ClientCallback;
import Chat.shared.networking.RMIServer;
import Chat.shared.networking.User;
import Chat.shared.networking.UserInfo;
import Chat.shared.transferobjects.Message;

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
  private List<ClientCallback> commonChatClientList;
  private ClientCallback clientCallback;

  public RMIServerImpl(ServerModel serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModel = serverModel;
    commonChatClientList = new ArrayList<>();
    serverModel.addListener("ActiveUsers", this::onActiveUsers);
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", this);
  }

  @Override public void loginUser(String username, String password)
  {
    serverModel.loginUser(username, password);
  }

  @Override public void sendMessage(Message message) throws RemoteException
  {
    for (ClientCallback client : commonChatClientList) {
      client.sendMessageResult(message);
    }
  }

  @Override public void registerUser(String un, String pw){
    serverModel.registerUser(un, pw);
  }

  @Override public void registerCommonChat(ClientCallback clientCallback)
  {
    System.out.println("arrived at server");
    commonChatClientList.add(clientCallback);
  }


  @Override public void editProfile(String un, String pw, String fn, String ln,
      String age, String pn, String pnumb, String email)
  {
    serverModel.editProfile(un, pw, fn, ln, age, pn, pnumb, email);
  }

  @Override public void getUserList(ClientCallback clientCallback) throws RemoteException
  {
    this.clientCallback = clientCallback;
    serverModel.getUserList();
    System.out.println("server network");
  }

  @Override public void onActiveUsers(PropertyChangeEvent event)
  {
    try
    {
      clientCallback.sendActiveUsers(event);
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

  @Override public UserInfo getCurrentUserInfo()
  {
    return serverModel.getUserInfo();
  }

  @Override public void seeUserInfo(String username, String firstName,
      String lastName,String age, String profileName, String email, String phoneNumber)
  {
    serverModel.seeUserInfo(username, firstName, lastName, age, profileName, email, phoneNumber);
  }
}
