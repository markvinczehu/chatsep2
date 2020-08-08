package DAO;

import Chat.shared.networking.User;
import Chat.shared.networking.UserInfo;

import java.sql.*;

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
    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=user_info", "postgres", "293150");
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
    System.out.println("User info test");
    try(Connection connection = getConnection())
    {
      String firstName;
          String lastName;
          String age;
          String profileName;
          String email;
         String  phoneNumber;
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM userInfo WHERE username =?");
      statement.setString(1, username);
      ResultSet resultSet = statement.executeQuery();
      if(resultSet.next())
      {
        username = resultSet.getString("username");
        firstName = resultSet.getString("firstname");
        lastName = resultSet.getString("lastname");
        age = resultSet.getString("age");
        profileName = resultSet.getString("profilename");
        email = resultSet.getString("email");
        phoneNumber = resultSet.getString("phonenumber");
        return new UserInfo(username,firstName,lastName,age,profileName,email,phoneNumber);
      }
      else
      {
        return null;
      }
    }
  }
}
