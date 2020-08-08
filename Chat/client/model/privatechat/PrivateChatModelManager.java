package Chat.client.model.privatechat;

import Chat.client.network.privatechat.PrivateChatClient;
import Chat.shared.networking.User;
import Chat.shared.transferobjects.Message;
import Chat.shared.transferobjects.PrivateMessage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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

    @Override
    public void sendMessage(int fromUser, int toUser, String message) {
        client.sendMessage(fromUser, toUser, message);
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
