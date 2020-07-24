package Chat.server;

import Chat.server.model.ServerModel;
import Chat.server.model.ServerModelManager;
import Chat.server.network.RMIServerImpl;
import Chat.shared.networking.RMIServer;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
  public static void main(String[] args) throws RemoteException, AlreadyBoundException {
    RMIServerImpl ss = new RMIServerImpl(new ServerModelManager());
    ss.startServer();
  }
}
