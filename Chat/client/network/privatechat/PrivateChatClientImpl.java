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
    public void sendMessage(int fromUser, int toUser, String message) {
        try
        {
            server.sendPrivateMessage(fromUser, toUser, message);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
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