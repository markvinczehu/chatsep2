package Chat.server;

import Chat.server.network.RMIServerImpl;
import Chat.shared.networking.RMIServer;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    RMIServer server = new RMIServerImpl();
    Registry reg = LocateRegistry.createRegistry(1099);
    reg.bind("Server", server);
    System.out.println("Server started");
  }
}
