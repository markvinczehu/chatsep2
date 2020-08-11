package DAO;

import Chat.shared.networking.User;
import Chat.shared.networking.UserInfo;
import Chat.shared.transferobjects.Message;
import Chat.shared.transferobjects.PrivateMessage;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO
{
  void create(String username, String password) throws SQLException;
  void read(String name, String pass) throws SQLException;
  void updateName(String name) throws SQLException;
  void updateAge(int age) throws SQLException;
  void delete(String name) throws SQLException;
  UserInfo getInfo(String username) throws SQLException;
  boolean checkUser(String username, String password) throws SQLException;
  ArrayList<UserInfo> getAllUsers() throws SQLException;
  boolean registrationCheck(String username) throws SQLException;
  void setOnline(String username, boolean status) throws SQLException;
  void createPrivateMessage(PrivateMessage privateMessage) throws SQLException;
  int getID(String username) throws SQLException;
  int createGuestUser(String guestName) throws SQLException;
  ArrayList<PrivateMessage> getPrivateMessages(int fromUser, int toUser) throws SQLException;
  void updateUser(UserInfo userInfo) throws SQLException;
}
