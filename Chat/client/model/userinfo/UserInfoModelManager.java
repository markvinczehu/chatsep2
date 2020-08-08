package Chat.client.model.userinfo;

import Chat.client.network.userinfo.UserInfoClient;
import Chat.shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UserInfoModelManager implements UserInfoModel
{
  private UserInfoClient userInfoClient;
  private PropertyChangeSupport support;

  public UserInfoModelManager (UserInfoClient userInfoClient)
  {
    this.userInfoClient=userInfoClient;
    support = new PropertyChangeSupport(this);
    userInfoClient.startClient();
    userInfoClient.addListener("UserInfo", this::onUserInfo);
  }

  @Override public void getInfo()
  {
    userInfoClient.getInfo();
  }

  @Override public void onFriendRequest()
  {

  }

  @Override public void onPrivateConversation()
  {

  }

  @Override public void onUserInfo(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
    System.out.println("back to userinfomodel");
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
