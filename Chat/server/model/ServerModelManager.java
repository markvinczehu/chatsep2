package Chat.server.model;

import DAO.DAO;
import DAO.DAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServerModelManager implements ServerModel
{
  private ArrayList<String> users;
  private DAO database = DAOImpl.getInstance();

  public ServerModelManager()
  {
    users = new ArrayList<String>();
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

  @Override public void sendMessage()
  {
    System.out.println("message sent");
  }

  @Override public void registerUser(String un, String pw)
  {
    System.out.println("Account created");
  }
}
