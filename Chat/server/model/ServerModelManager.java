package Chat.server.model;

import Chat.shared.networking.User;
import Chat.shared.networking.UserInfo;
import Chat.shared.transferobjects.Message;
import Chat.shared.transferobjects.PrivateMessage;
import Chat.shared.util.Subject;
import DAO.DAO;
import DAO.DAOImpl;
import javafx.beans.property.ListProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelManager implements ServerModel
{
  private DAO database = DAOImpl.getInstance();
  private PropertyChangeSupport support;
  private User currentUser;
  private UserInfo userInfo;
  private int i = 0;

  public ServerModelManager()
  {
    support = new PropertyChangeSupport(this);
  }
  
  @Override public boolean loginUser(String username, String password)
  {

    try{
      if(database.checkUser(username,password))
      {
        database.setOnline(username, true);
        currentUser = new User(username,password);
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
      currentUser = database.create(un, pw);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    System.out.println("Account created");
  }

  @Override public void editProfile(String un, String pw, String fn, String ln,
      String age, String pnumb, String email)
  {
    System.out.println("Profile edited");
  }

  @Override public void getUserList()
  {
    try
    {
      ArrayList<User> list = database.getAllUsers();
      ArrayList<String> allUsers = new ArrayList<>();
      for (User u : list)
      {
        allUsers.add(u.getUsername());
      }
      support.firePropertyChange("UsersList", null, allUsers);
      System.out.println("server model");
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    
  }

  @Override public User getCurrentUser()
  {
    return currentUser;
  }

  @Override public Message sendMessage(String input)
  {
    return new Message(currentUser.getUsername(), input);
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
      System.out.println("UserInfo in the servermodel is: " +userInfo.getUsername() + " " + userInfo.getIsOnline());
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

  @Override public void sendPrivateMessage(PrivateMessage message)
  {
    try
    {
      database.createPrivateMessage(message);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public String getToUserForPM()
  {
    return userInfo.getUsername();
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
