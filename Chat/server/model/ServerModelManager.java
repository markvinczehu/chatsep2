package Chat.server.model;

import Chat.shared.transferobjects.UserInfo;
import Chat.shared.transferobjects.PrivateMessage;
import DAO.DAO;
import DAO.DAOImpl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelManager implements ServerModel
{
  private DAO database = DAOImpl.getInstance();
  private PropertyChangeSupport support;
  private UserInfo currentUser;
  private UserInfo userInfo;
  private String guestUser;
  private int i = 0;

  public ServerModelManager()
  {
    support = new PropertyChangeSupport(this);
    currentUser = new UserInfo();
  }
  
  @Override public boolean loginUser(String username, String password)
  {

    try{
      guestUser = null;
      if(database.checkUser(username,password))
      {
        database.setOnline(username, true);
        currentUser = database.getInfo(username);
        return true;
      }
      else return false;
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return false;
  }

  @Override public void registerUser(String un, String pw){
    try
    {
      guestUser = null;
      database.create(un, pw);
      currentUser = database.getInfo(un);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void editProfile(String un, String pw, String fn, String ln,
      String age, String pnumb, String email)
  {
    try
    {
      currentUser = new UserInfo(currentUser.getId(), un, pw, fn, ln, age, email, pnumb, currentUser.getIsOnline());
      database.updateUser(currentUser);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void getUserList()
  {
    try
    {
      ArrayList<UserInfo> list = database.getAllUsers();
      ArrayList<String> allUsers = new ArrayList<>();
      for (UserInfo u : list)
      {
        allUsers.add(u.getUsername());
      }
      support.firePropertyChange("UsersList", null, allUsers);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    
  }

  @Override public UserInfo getCurrentUser()
  {
    return currentUser;
  }

  @Override public void getUserInfo(String username)
  {
    try
    {
      userInfo = database.getInfo(username);
      if(i >= 1)
      {
        getInfo();
      }
      i++;
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void getInfo()
  {
    support.firePropertyChange("UserInfo", null, userInfo);
  }

  @Override public void sendPrivateMessage(PrivateMessage privateMessage)
  {
    try
    {
      database.createPrivateMessage(privateMessage);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public int getToUserForPM()
  {
    return userInfo.getId();
  }

  @Override public void setGuestUser()
  {
    try
    {
      guestUser = "anonymous" + (int)(Math.random()*1000);
      int id = database.createGuestUser(guestUser);
      currentUser.setUsername(guestUser);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public boolean getGuestUser()
  {
    return guestUser != null;
  }

  @Override public ArrayList<PrivateMessage> getMessageLog()
  {
    int toUser = getToUserForPM();
    int fromUser = getCurrentUser().getId();
    try
    {
      return database.getPrivateMessages(fromUser, toUser);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public UserInfo getToUser()
  {
    return userInfo;
  }

  @Override public void logoutUser()
  {
    try
    {
      database.setOnline(currentUser.getUsername(), false);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void addListener(String evtName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(evtName,listener);
  }

  @Override public void removeListener(String evtName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(evtName,listener);
  }
}
