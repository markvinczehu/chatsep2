package Chat.client.network.commonchat;

import Chat.shared.networking.ClientCallback;
import Chat.shared.networking.RMIServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CommonChatClientImpl implements CommonChatClient, ClientCallback
{
  private RMIServer server;

  public CommonChatClientImpl()
  {

  }

  @Override public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (RMIServer) registry.lookup("Server");
    }catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void sendMessage()
  {
    try
    {
      server.sendMessage();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }


}
