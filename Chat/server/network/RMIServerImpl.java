package Chat.server.network;

import Chat.client.network.commonchat.CommonChatClient;
import Chat.client.network.commonchat.CommonChatClientImpl;
import Chat.server.model.ServerModel;
import Chat.shared.networking.RMIServer;
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
  private List<CommonChatClient> commonChatClientList;

  public RMIServerImpl(ServerModel serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModel = serverModel;
    commonChatClientList = new ArrayList<>();
    serverModel.addListener("Message", this::onSendMessage);
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", this);
  }

  @Override public void loginUser(String username)
  {
    serverModel.loginUser(username);
  }

  @Override public void sendMessage(Message message) throws RemoteException
  {
    serverModel.sendMessage(message);
  }

  @Override public void registerUser(String un, String pw)
  {
    serverModel.registerUser(un, pw);
  }

  @Override public void registerCommonChat(CommonChatClient commonChatClient)
  {
    commonChatClientList.add(commonChatClient);
  }


  @Override public void onSendMessage(PropertyChangeEvent propertyChangeEvent)
  {

  }

  public void onSendMessage()
  {

  }

}
