package Chat.client.network;

import Chat.shared.networking.ClientCallback;
import Chat.shared.networking.RMIServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient implements Client, ClientCallback
{
  private RMIServer server;

  public RMIClient () throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  public void start() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (RMIServer) registry.lookup("Server");
  }

  public void Chat(String argument)
  {
    try
    {
      server.message(argument, this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
      throw new RuntimeException("Unable to establish connection");
  }

  @Override public void messageResult(String result)
  {
    System.out.println("Result " + result);
  }
}
