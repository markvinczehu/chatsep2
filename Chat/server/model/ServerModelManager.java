package Chat.server.model;

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
  private ArrayList<String> activeUsers;
  private PropertyChangeSupport support;

  public ServerModelManager()
  {
    users = new ArrayList<String>();
    activeUsers = new ArrayList<String>();
    support = new PropertyChangeSupport(this);
  }
  
  @Override public void loginUser(String username, String password)
  {
    try{
      database.read(username, password);
       }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void sendMessage(Message message)
  {
    System.out.println(message.toString());
    support.firePropertyChange("SendMessage", null, message);
  }

  @Override public void registerUser(String un, String pw) throws SQLException {
    DAOImpl.getInstance().create(un, pw);
    System.out.println("Account created");
  }

  @Override public void showActiveUsers(ListProperty activeUsers) {  }

  @Override public void editProfile(String un, String pw, String fn, String ln,
      String age, String pn, String pnumb, String email)
  {
    System.out.println("Profile edited");
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
