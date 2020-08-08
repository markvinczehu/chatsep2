package DAO;

import Chat.shared.networking.User;
import Chat.shared.networking.UserInfo;
import Chat.shared.transferobjects.Message;
import Chat.shared.transferobjects.PrivateMessage;

import java.sql.*;
import java.util.ArrayList;

public class DAOImpl implements DAO
{
  private static DAOImpl instance;

  private DAOImpl()
  {
    try
    {
      DriverManager.registerDriver(new org.postgresql.Driver());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  public static synchronized DAOImpl getInstance()
  {
    if(instance == null)
    {
      instance = new DAOImpl();
    }
    return instance;
  }

  private Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=test", "postgres", "293150");
  }

  @Override public User create(String username, String password) throws SQLException
  {
    System.out.println("123123");
    try(Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement(
          "insert into userInfo(username, password) values (?, ?);");
      statement.setString(1, String.valueOf(username));
      statement.setString(2, String.valueOf(password));
      System.out.println("blabla");
      statement.executeUpdate();
      return new User(username, password);
    }
  }

  @Override public void read(String name, String pass) throws SQLException
  {
    System.out.println("123123");
    try(Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM userInfo WHERE username = ?");
      statement.setString(1, name);
      statement.setString(1, pass);
      ResultSet resultSet = statement.executeQuery();
      if(resultSet.next()) {
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        System.out.println(name + " " + pass);
        }
    else
        System.out.println("Account does not exist");
      }
    }

  @Override public void updateName(String name) throws SQLException
  {

  }

  @Override public void updateAge(int age) throws SQLException
  {

  }

  @Override public void delete(String name) throws SQLException
  {

  }

  @Override public UserInfo getInfo(String username) throws SQLException
  {
    try(Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM userinfo WHERE username = ?");
      statement.setString(1, username);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String name = resultSet.getString("username");
        String firstname = resultSet.getString("firstname");
        String lastname = resultSet.getString("lastname");
        String age = resultSet.getString("age");
        String email = resultSet.getString("email");
        String phoneNumber = resultSet.getString("phonenumber");
        Boolean isOnline = resultSet.getBoolean("isonline");
        System.out.println(name + " " + isOnline);
        return new UserInfo(name, firstname, lastname, age, email, phoneNumber,
            isOnline);
      }
      else
      {
        System.out.println("Account does not exist");
        return null;
      }
    }
  }

  @Override public boolean checkUser(String username, String password) throws SQLException
  {
    System.out.println("getting user");
    try(Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM userinfo WHERE username = ?");
      statement.setString(1, username);
      ResultSet resultSet = statement.executeQuery();
      if(resultSet.next()) {
        String name = resultSet.getString("username");
        String pass = resultSet.getString("password");
        if(name.equals(username) && password.equals(pass))
        {
          System.out.println("correct");
          return true;
        }
        else return false;
      }
      else
      {
        System.out.println("Account does not exist");
        return false;
      }
    }
  }

  @Override public ArrayList<User> getAllUsers() throws SQLException
  {
    System.out.println("getting all users");
    try(Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM userinfo");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<User> users = new ArrayList<>();
      while(resultSet.next())
      {
        String u = resultSet.getString("username");
        String p = resultSet.getString("password");
        User user = new User(u,p);
        users.add(user);
      }
      return users;
      }

  }

  public boolean registrationCheck(String username) throws SQLException {
    String dbUsername;
    try (Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM userInfo WHERE username = ?");
      statement.setString(1, username);
      ResultSet rs = statement.executeQuery();
      if(rs.next()) {
          System.out.println("Account already exists");
          return false;
      }
      else
        System.out.println("DAOcreation");
      System.out.println(username);
      return true;
    }
  }

  @Override public void setOnline(String username, boolean status) throws SQLException
  {
    try(Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("UPDATE userinfo SET isOnline = ? WHERE username = ?");
      statement.setBoolean(1, status);
      statement.setString(2, username);
      statement.executeUpdate();
    }
  }

  @Override public void createPrivateMessage(PrivateMessage message)
      throws SQLException
  {
    try(Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement(
          "insert into privateusermessages(fromuser, touser, body, createdate) values (?, ?, ?, ?);");
      statement.setString(1, String.valueOf(message.getFromUser()));
      statement.setString(2, String.valueOf(message.getToUser()));
      statement.setString(3, String.valueOf(message.getMsg()));
      statement.setString(4, String.valueOf(message.getDate()));
      statement.executeUpdate();
      System.out.println("private message created");
    }
  }
}
