package Chat.client.network.privatechat;

import Chat.client.network.Client;
import Chat.client.network.commonchat.CommonChatClient;
import Chat.shared.networking.PrivateChatCallback;
import Chat.shared.networking.MessageDAO;
import Chat.shared.networking.PrivateChatCallback;
import Chat.shared.networking.RMIServer;
import Chat.shared.networking.User;
import Chat.shared.transferobjects.Message;
import Chat.shared.transferobjects.PrivateMessage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class PrivateChatClientImpl implements PrivateChatClient,
    PrivateChatCallback
{
    private RMIServer server;
    private PropertyChangeSupport support;

    public PrivateChatClientImpl() {
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void sendMessage(PrivateMessage message) {
        try
        {
            server.sendPrivateMessage(message);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String getFromUserForPM() {
        try
        {
            return server.getCurrentUser().getUsername();
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override public String getToUserForPM()
    {
        try
        {
            return server.getToUserForPM();
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return null;
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