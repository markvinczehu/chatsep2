package Chat.client.network.registration;

import Chat.shared.networking.RMIServer;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RegistrationClientImpl implements RegistrationClient, Remote
{
  private RMIServer server;

  public RegistrationClientImpl()
  {

  }

  @Override public void registerUser(String un, String pw)
  {
    server.registerUser(un, pw);
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
}
