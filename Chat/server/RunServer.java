package Chat.server;

import Chat.server.model.ServerModelManager;
import Chat.server.network.RMIServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args) throws RemoteException, AlreadyBoundException {
    RMIServerImpl ss = new RMIServerImpl(new ServerModelManager());
    ss.startServer();
  }
}
