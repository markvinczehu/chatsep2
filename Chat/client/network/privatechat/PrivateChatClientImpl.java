package Chat.client.network.privatechat;

import Chat.client.network.commonchat.CommonChatClient;
import Chat.shared.networking.ClientCallback;
import Chat.shared.networking.RMIServer;
import Chat.shared.networking.User;
import Chat.shared.transferobjects.Message;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class PrivateChatClientImpl implements PrivateChatClient, ClientCallback {
    private RMIServer server;
    private PropertyChangeSupport support;

    public PrivateChatClientImpl() {
        support = new PropertyChangeSupport(this);
    }


    @Override
    public void sendMessage(Message message) {

    }

    @Override
    public User getCurrentUser() {
        return null;
    }

    @Override
    public void sendMessageResult(Message message) throws RemoteException {

    }

    @Override
    public void sendActiveUsers(PropertyChangeEvent event) throws RemoteException {

    }
}