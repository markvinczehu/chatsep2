package Chat.client.network.commonchat;

import Chat.client.network.Client;
import Chat.shared.transferobjects.Message;

public interface CommonChatClient extends Client
{
  void sendMessage(Message message);
}
