package DAO;

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
    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=test", "postgres", "293150");
  }

  @Override public void create(String name, int age) throws SQLException
  {
    try(Connection connection = getConnection()){
      PreparedStatement statement = connection.prepareStatement(
          "insert into persontest(name, age) values (?, ?);");
      statement.setString(1, name);
      statement.setInt(2, age);
      statement.executeUpdate();
    }
  }

  @Override public void read(String name, String pass) throws SQLException
  {
    try(Connection connection = getConnection()) {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM registereduser WHERE username = ?");
      statement.setString(1, name);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        System.out.println(username + " " + password);
      } else {
        System.out.println("Account does not exist");
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
}
