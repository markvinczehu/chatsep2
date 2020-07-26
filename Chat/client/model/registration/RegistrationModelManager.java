package Chat.client.model.registration;
import Chat.client.network.Client;

public class RegistrationModelManager implements RegistrationModel{

    private Client client;

    public RegistrationModelManager(Client client)
    {
        this.client = client;
        client.startClient();
    }


    @Override
    public void createAccount(String username, String password, String passredo) {

    }

    @Override
    public void registerUser(String un, String pw) {

    }
}
