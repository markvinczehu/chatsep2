package Chat.server.network;

import Chat.server.model.ServerModel;
import Chat.shared.networking.RMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerImpl implements RMIServer
{
  private ServerModel serverModel;

  public RMIServerImpl(ServerModel serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.serverModel = serverModel;
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

  @Override public void sendMessage() throws RemoteException
  {
    serverModel.sendMessage();
  }

  @Override public void registerUser(String un, String pw)
  {
    serverModel.registerUser(un, pw);
  }
}
