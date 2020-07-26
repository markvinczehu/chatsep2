package Chat.client.model.commonchat;

import Chat.client.network.commonchat.CommonChatClient;

public class CommonChatModelManager implements CommonChatModel
{
  private CommonChatClient client;

  public CommonChatModelManager(CommonChatClient client)
  {
    this.client = client;
    client.startClient();
  }

  @Override public void sendMessage()
  {
    client.sendMessage();
  }
}
