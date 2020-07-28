package Chat.server.model;

import Chat.shared.transferobjects.Message;
import Chat.shared.util.Subject;
import DAO.DAO;
import DAO.DAOImpl;
import javafx.beans.property.ListProperty;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelManager implements ServerModel
{
  private ArrayList<String> users;
  private DAO database = DAOImpl.getInstance();
  private ArrayList<String> activeUsers;
  private PropertyChangeSupport support;

  public ServerModelManager()
  {
    users = new ArrayList<String>();
    activeUsers = new ArrayList<String>();
  }
  
  @Override public void loginUser(String username)
  {
    try{
      database.read(username);
       }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void sendMessage(Message message)
  {
    System.out.println("message sent");


  }

  @Override public void registerUser(String un, String pw)
  {
    System.out.println("Account created");
  }

  @Override public void showActiveUsers(ListProperty activeUsers) {  }

  @Override public void addListener(String evtName,
      PropertyChangeListener listener)
  {
    //support.addPropertyChangeListener(evtName,listener);
  }

  @Override public void removeListener(String evtName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(evtName,listener);
  }
}
