package Chat.client.network;

import Chat.shared.util.Subject;

public interface Client extends Subject
{
  void startClient();
}
