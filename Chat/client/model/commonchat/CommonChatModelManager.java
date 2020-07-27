package Chat.client.model.commonchat;

import Chat.client.network.commonchat.CommonChatClient;
import Chat.shared.transferobjects.Message;

public class CommonChatModelManager implements CommonChatModel
{
  private CommonChatClient client;

  public CommonChatModelManager(CommonChatClient client)
  {
    this.client = client;
    client.startClient();
  }

  @Override public void sendMessage(Message message)
  {
    client.sendMessage(message);
  }
}
