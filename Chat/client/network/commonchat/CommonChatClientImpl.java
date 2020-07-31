package Chat.client.network.commonchat;

import Chat.shared.networking.ClientCallback;
import Chat.shared.networking.RMIServer;
import Chat.shared.transferobjects.Message;
import Chat.shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CommonChatClientImpl implements CommonChatClient, ClientCallback
{
  private RMIServer server;
  private PropertyChangeSupport support;

  public CommonChatClientImpl()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (RMIServer) registry.lookup("Server");
      //server.registerCommonChat(this);
    }catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void sendMessage(Message message)
  {
    try
    {
      server.sendMessage(message, this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void sendMessageResult(PropertyChangeEvent event) throws RemoteException
  {
    support.firePropertyChange(event);
    System.out.println("arrived at client");
  }

  @Override public void addListener(String evtName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(evtName, listener);
  }

  @Override public void removeListener(String evtName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(evtName, listener);
  }
}
