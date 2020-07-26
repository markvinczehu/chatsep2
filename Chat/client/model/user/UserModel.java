package Chat.client.model.user;

public interface UserModel {
    void registerUser(String un, String pw);
    void message (String message);
    void addFriend(Object object);
}
