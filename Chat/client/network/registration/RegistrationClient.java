package Chat.client.network.registration;

import Chat.client.network.Client;

public interface RegistrationClient extends Client
{
  void registerUser(String un, String pw);
}
