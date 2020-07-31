package Chat.client.network;

import Chat.shared.networking.ClientCallback;
import Chat.shared.networking.RMIServer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient implements Client, ClientCallback
{
  private RMIServer server;

  public RMIClient ()
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

  @Override public void sendMessageResult(PropertyChangeEvent event)
      throws RemoteException
  {

  }

  @Override public void addListener(String evtName,
      PropertyChangeListener listener)
  {

  }

  @Override public void removeListener(String evtName,
      PropertyChangeListener listener)
  {

  }
}
