package Chat.client.network.privatechat;

import Chat.shared.networking.User;
import Chat.shared.transferobjects.Message;

public interface PrivateChatClient {
    void sendMessage(Message message);
    User getCurrentUser();
}
