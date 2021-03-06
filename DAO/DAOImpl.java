package DAO;

import Chat.shared.transferobjects.UserInfo;
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
    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=test",
        "postgres", "293150");
  }

  @Override public void create(String username, String password) throws SQLException
  {
    try(Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement(
          "insert into userInfo(username, password) values (?, ?);");
      statement.setString(1, String.valueOf(username));
      statement.setString(2, String.valueOf(password));
      statement.executeUpdate();
    }
  }

  @Override public void read(String name, String pass) throws SQLException
  {
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
        int id = resultSet.getInt("regid");
        String name = resultSet.getString("username");
        String password = resultSet.getString("password");
        String firstname = resultSet.getString("firstname");
        String lastname = resultSet.getString("lastname");
        String age = resultSet.getString("age");
        String email = resultSet.getString("email");
        String phoneNumber = resultSet.getString("phonenumber");
        Boolean isOnline = resultSet.getBoolean("isonline");
        return new UserInfo(id, name, password, firstname, lastname, age, email, phoneNumber,
            isOnline);
      }
      else
      {
        return null;
      }
    }
  }

  @Override public boolean checkUser(String username, String password) throws SQLException
  {
    try(Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM userinfo WHERE username = ?");
      statement.setString(1, username);
      ResultSet resultSet = statement.executeQuery();
      if(resultSet.next()) {
        String name = resultSet.getString("username");
        String pass = resultSet.getString("password");
        if(name.equals(username) && password.equals(pass))
        {
          return true;
        }
        else return false;
      }
      else
      {
        return false;
      }
    }
  }

  @Override public ArrayList<UserInfo> getAllUsers() throws SQLException
  {
    try(Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM userinfo");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<UserInfo> users = new ArrayList<>();
      while(resultSet.next())
      {
        String u = resultSet.getString("username");
        UserInfo user = new UserInfo(u);
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
          return false;
      }
      else
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

  @Override public void createPrivateMessage(PrivateMessage privateMessage)
      throws SQLException
  {
    try(Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement(
          "insert into privateusermessages(fromuser, touser, body, createdate) values (?, ?, ?, ?);");
      statement.setInt(1, privateMessage.getFromUser());
      statement.setInt(2, privateMessage.getToUser());
      statement.setString(3, privateMessage.getMsg());
      statement.setString(4, privateMessage.getDate());
      statement.executeUpdate();
    }
  }

  @Override public int getID(String username) throws SQLException
  {
    try (Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM userInfo WHERE username = ?");
      statement.setString(1, username);
      ResultSet rs = statement.executeQuery();
      if(rs.next()) {
        return rs.getInt("regid");
      }
      else
        return -1;
    }
  }

  @Override public int createGuestUser(String guestName) throws SQLException
  {
    try (Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("INSERT INTO guestuser(guestname) values(?)", PreparedStatement.RETURN_GENERATED_KEYS);
      statement.setString(1, guestName);
      statement.executeUpdate();
      ResultSet keys = statement.getGeneratedKeys();
      if(keys.next()) {
        return keys.getInt("guestid");
      }
      else
        return -1;
    }
  }

  @Override public ArrayList<PrivateMessage> getPrivateMessages(int fromUser,
      int toUser) throws SQLException
  {
    try (Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM privateusermessages WHERE fromuser = ? and touser = ?");
      statement.setInt(1, fromUser);
      statement.setInt(2, toUser);
      ResultSet rs = statement.executeQuery();
      ArrayList<PrivateMessage> list = new ArrayList<>();
      while(rs.next())
      {
        int fu = rs.getInt("fromuser");
        int tu = rs.getInt("touser");
        String mess = rs.getString("body");
        String date = rs.getString("createdate");
        PrivateMessage pm = new PrivateMessage(fu, tu, mess, date);
        list.add(pm);
      }
      return list;
    }
  }

  @Override public void updateUser(UserInfo userInfo) throws SQLException
  {
    try (Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("update userinfo set username = ?, password = ?, firstname = ?, lastname = ?, age = ?, email = ?, phonenumber = ? where regid = ?");
      statement.setString(1, userInfo.getUsername());
      statement.setString(2, userInfo.getPassword());
      statement.setString(3, userInfo.getFirstName());
      statement.setString(4, userInfo.getLastName());
      statement.setInt(5, Integer.parseInt(userInfo.getAge()));
      statement.setString(6, userInfo.getEmail());
      statement.setString(7, userInfo.getPhoneNumber());
      statement.setInt(8, userInfo.getId());
      statement.executeUpdate();
    }
  }
}
