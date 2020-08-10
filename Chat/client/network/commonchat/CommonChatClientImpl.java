package Chat.client.network.commonchat;


import Chat.shared.networking.CommonChatCallback;
import Chat.shared.networking.RMIServer;
import Chat.shared.networking.UserInfo;
import Chat.shared.transferobjects.Message;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CommonChatClientImpl implements CommonChatClient,
    CommonChatCallback
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
      server.registerCommonChat(this);
    }catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void sendMessage(Message message)
  {
    try
    {
      server.sendMessage(message);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void getUserList()
  {
    try
    {
      server.getUserList(this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public UserInfo getCurrentUser()
  {
    try
    {
      return server.getCurrentUser();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void getUserInfo(String username)
  {
    try
    {
      server.getUserInfo(username);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public boolean getGuestUser()
  {
    try
    {
      return server.getGuestUser();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  @Override public void sendMessageResult(Message message)
  {
    support.firePropertyChange("SendMessage", null, message);
    System.out.println("arrived at client");
  }

  @Override public void sendUserList(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
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
