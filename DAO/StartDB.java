package DAO;

import java.sql.SQLException;

public class StartDB
{
  public static void main(String[] args)
  {
    String name = "Alex";
    int age = 20;
    try{
      DAOImpl.getInstance().create(name, age);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }
}
