package DAO;

import Chat.shared.networking.User;
import Chat.shared.networking.UserInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO
{
  User create(String username, String password) throws SQLException;
  void read(String name, String pass) throws SQLException;
  void updateName(String name) throws SQLException;
  void updateAge(int age) throws SQLException;
  void delete(String name) throws SQLException;
  UserInfo getInfo(String username) throws SQLException;
  boolean checkUser(String username, String password) throws SQLException;
  ArrayList<User> getAllUsers() throws SQLException;
  boolean registrationCheck(String username) throws SQLException;
  void setOnline(String username, boolean status) throws SQLException;
}
