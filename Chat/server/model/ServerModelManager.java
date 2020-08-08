package Chat.server.model;

import Chat.shared.networking.User;
import Chat.shared.transferobjects.Message;
import Chat.shared.util.Subject;
import DAO.DAO;
import DAO.DAOImpl;
import javafx.beans.property.ListProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelManager implements ServerModel
{
  private ArrayList<String> users;
  private DAO database = DAOImpl.getInstance();
  private ArrayList<String> allUsersList;
  private PropertyChangeSupport support;
  private User currentUser;

  public ServerModelManager()
  {
    users = new ArrayList<String>();
    allUsersList = new ArrayList<String>();
    User u2 = new User("Matej", "123546");
    User u3 = new User("Dimitrios", "123546");
    User u4 = new User("Mark", "123546");
    allUsersList.add(u2.toUserList());
    allUsersList.add(u3.toUserList());
    allUsersList.add(u4.toUserList());
    support = new PropertyChangeSupport(this);
  }
  
  @Override public boolean loginUser(String username, String password)
  {

    try{
      if(database.checkUser(username,password))
      {
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
      String age, String pn, String pnumb, String email)
  {
    System.out.println("Profile edited");
  }

  @Override public void getUserList()
  {
    try
    {
      ArrayList<User> list = database.getAllUsers();
      for (User u : list)
      {
        allUsersList.add(u.toUserList());
      }
      support.firePropertyChange("ActiveUsers", null, allUsersList);
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
