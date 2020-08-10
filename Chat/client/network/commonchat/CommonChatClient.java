package Chat.client.network.commonchat;

import Chat.client.network.Client;
import Chat.shared.networking.UserInfo;
import Chat.shared.transferobjects.Message;

public interface CommonChatClient extends Client
{
  void sendMessage(Message message);
  void getUserList();
  UserInfo getCurrentUser();
  void getUserInfo(String username);
  boolean getGuestUser();
}
