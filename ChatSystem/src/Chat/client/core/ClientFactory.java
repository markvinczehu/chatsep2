package Chat.client.core;

import Chat.client.network.Client;
import Chat.client.network.RMIClient;

public class ClientFactory
{
  private Client client;

  public Client getClient() {
    if(client == null) {
      client = new RMIClient();
    }
    return client;
  }
}
