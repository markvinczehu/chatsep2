package Chat.client.network;

import Chat.shared.networking.ClientCallback;
import Chat.shared.networking.RMIServer;

import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient implements Client, ClientCallback
{
  public static void main(String[] args)
      throws RemoteException, NotBoundException
  {
    System.setProperty("java.security.policy", "security.policy");

    if (System.getSecurityManager() == null)
    {
      System.setSecurityManager(new RMISecurityManager());
    }

    RMIClient client = new RMIClient();
  }

  private RMIServer server;
  public RMIClient () {

  }

  public void start() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (RMIServer) registry.lookup("Chat");

  }
}
