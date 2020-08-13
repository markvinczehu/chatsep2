package Chat.client.network.privatechat;

import Chat.shared.networking.*;
import Chat.shared.networking.PrivateChatCallback;
import Chat.shared.transferobjects.Message;
import Chat.shared.transferobjects.PrivateMessage;
import Chat.shared.transferobjects.UserInfo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class PrivateChatClientImpl implements PrivateChatClient,
    PrivateChatCallback
{
    private RMIServer server;
    private PropertyChangeSupport support;

    public PrivateChatClientImpl() {
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void sendMessage(PrivateMessage privateMessage) {
        try
        {
            server.sendPrivateMessage(privateMessage);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    @Override public ArrayList<PrivateMessage> getMessageLog()
    {
        try
        {
            return server.getMessageLog();
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
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

    @Override public UserInfo getToUser()
    {
        try
        {
            return server.getToUser();
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getFromUserForPM() {
        try
        {
            return server.getCurrentUser().getId();
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return -1;
    }

    @Override public int getToUserForPM()
    {
        try
        {
            return server.getToUserForPM();
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void startClient() {
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

    @Override
    public void sendMessageResult(Message message) throws RemoteException {
        support.firePropertyChange("SendMessage", null, message);
        System.out.println("arrived at client");
    }

    @Override
    public void sendUserList(PropertyChangeEvent event) throws RemoteException {

    }

    @Override
    public void addListener(String evtName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(evtName, listener);
    }

    @Override
    public void removeListener(String evtName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(evtName, listener);
    }
}