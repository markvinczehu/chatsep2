package Chat.client.network.profile;

import Chat.shared.networking.ClientCallback;
import Chat.shared.networking.RMIServer;
import Chat.shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ProfileClientImpl implements ProfileClient, ClientCallback
{
  private RMIServer server;
  private PropertyChangeSupport support;

  public ProfileClientImpl()
  {
    support = new PropertyChangeSupport(this);
  }

}
