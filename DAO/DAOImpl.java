package DAO;

import Chat.shared.networking.User;

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
}
