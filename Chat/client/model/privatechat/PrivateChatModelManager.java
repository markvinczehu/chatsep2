package Chat.client.model.privatechat;

import Chat.client.network.privatechat.PrivateChatClient;
import Chat.shared.transferobjects.UserInfo;
import Chat.shared.transferobjects.PrivateMessage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PrivateChatModelManager implements PrivateChatModel {
    private PrivateChatClient client;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public PrivateChatModelManager(PrivateChatClient client)
    {
        this.client = client;
        client.startClient();
        client.addListener("SendMessage" , this::onSendMessage);
    }

    @Override
    public int getFromUserForPM() {
        return client.getFromUserForPM();
    }

    @Override public int getToUserForPM()
    {
        return client.getToUserForPM();
    }

    @Override public ArrayList<PrivateMessage> getMessageLog()
    {
        return client.getMessageLog();
    }

    @Override public UserInfo getCurrentUser()
    {
        return client.getCurrentUser();
    }

    @Override public UserInfo getToUser()
    {
        return client.getToUser();
    }

    @Override
    public void sendMessage(PrivateMessage privateMessage) {
        client.sendMessage(privateMessage);
    }

    @Override
    public void onSendMessage(PropertyChangeEvent event) {
        support.firePropertyChange(event);
        System.out.println("arrived at model");
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
