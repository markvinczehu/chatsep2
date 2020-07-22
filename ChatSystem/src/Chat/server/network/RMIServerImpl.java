package Chat.server.network;

import Chat.shared.networking.RMIServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerImpl implements RMIServer
{
  public static void main(String[] args)
      throws RemoteException, MalformedURLException
  {
    Registry reg = LocateRegistry.createRegistry(1099);
    RMIServer rmiServer = new RMIServerImpl();
  }
  public RMIServerImpl() throws RemoteException, MalformedURLException
  {
    UnicastRemoteObject.exportObject(this, 0);
    RMIServer stub = (RMIServer) UnicastRemoteObject.exportObject(this,0);
    Naming.rebind("Chat", this);
    System.out.println("Starting Server..");
  }
}
