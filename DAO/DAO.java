package DAO;

import Chat.shared.networking.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO
{
  User create(String username, String password) throws SQLException;
  void read(String name, String pass) throws SQLException;
  void updateName(String name) throws SQLException;
  void updateAge(int age) throws SQLException;
  void delete(String name) throws SQLException;
  boolean checkUser(String username, String password) throws SQLException;
  ArrayList<User> getAllUsers() throws SQLException;
}
