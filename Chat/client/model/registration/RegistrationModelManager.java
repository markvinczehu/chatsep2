package Chat.client.model.registration;

import Chat.client.network.registration.RegistrationClient;

public class RegistrationModelManager implements RegistrationModel{

    private RegistrationClient registrationClient;

    public RegistrationModelManager(RegistrationClient client)
    {
        this.registrationClient = client;
        registrationClient.startClient();
    }

    @Override
    public void registerUserChecker(String un, String pw) {
        registrationClient.registerUser(un, pw);
    }
}
