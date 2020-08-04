package DAO;

import java.sql.SQLException;

public interface DAO
{
  void create(String name, int age) throws SQLException;
  void read(String name, String pass) throws SQLException;
  void updateName(String name) throws SQLException;
  void updateAge(int age) throws SQLException;
  void delete(String name) throws SQLException;
}
