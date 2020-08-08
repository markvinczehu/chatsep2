package Chat.client.network.profile;

import Chat.shared.networking.RMIServer;


import java.beans.PropertyChangeListener;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ProfileClientImpl implements ProfileClient, Remote
{
  private RMIServer server;

  public ProfileClientImpl()
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

  @Override public void addListener(String evtName,
      PropertyChangeListener listener)
  {

  }

  @Override public void removeListener(String evtName,
      PropertyChangeListener listener)
  {

  }

  @Override public void editProfile(String un, String pw, String fn, String ln,
      String age, String pnumb, String email)
  {
    try
    {
      server.editProfile(un, pw, fn, ln, age, pnumb, email);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
