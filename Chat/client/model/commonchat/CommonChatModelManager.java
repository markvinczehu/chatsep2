package Chat.client.model.commonchat;

import Chat.client.network.commonchat.CommonChatClient;
import Chat.shared.transferobjects.UserInfo;
import Chat.shared.transferobjects.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CommonChatModelManager implements CommonChatModel
{
  private CommonChatClient client;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public CommonChatModelManager(CommonChatClient client)
  {
    this.client = client;
    client.startClient();
    client.addListener("SendMessage" , this::onSendMessage);
    client.addListener("UsersList", this::onUserList);
  }

  @Override public void sendMessage(Message message)
  {
    client.sendMessage(message);
  }

  @Override public void onSendMessage(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
    System.out.println("arrived at model");
  }

  @Override public void getUserList()
  {
    client.getUserList();
  }

  @Override public void onUserList(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
  }

  @Override public UserInfo getCurrentUser()
  {
    return client.getCurrentUser();
  }

  @Override public void getUserInfo(String username)
  {
    client.getUserInfo(username);
  }

  @Override public boolean getGuestUser()
  {
    return client.getGuestUser();
  }

  @Override public void logoutUser()
  {
    client.logoutUser();
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
