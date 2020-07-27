package Chat.client.model.commonchat;

import Chat.shared.transferobjects.Message;

public interface CommonChatModel
{
  void sendMessage(Message message);
}
