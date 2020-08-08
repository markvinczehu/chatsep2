package Chat.client.network.commonchat;

import Chat.client.network.Client;
import Chat.shared.networking.User;

public interface CommonChatClient extends Client
{
  void sendMessage(String input);
  void getUserList();
  User getCurrentUser();
  void seeUserInfo(String username);
}
