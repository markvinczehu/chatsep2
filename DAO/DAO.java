package DAO;

import Chat.shared.networking.User;
import Chat.shared.networking.UserInfo;

import java.sql.SQLException;

public interface DAO
{
  User create(String username, String password) throws SQLException;
  void read(String name, String pass) throws SQLException;
  void updateName(String name) throws SQLException;
  void updateAge(int age) throws SQLException;
  void delete(String name) throws SQLException;
  UserInfo getInfo(String username)
      throws SQLException;
}
