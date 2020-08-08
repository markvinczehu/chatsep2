package Chat.client.model.privatechat;

import Chat.shared.util.Subject;

import java.beans.PropertyChangeEvent;

public interface PrivateChatModel extends Subject {
    void sendMessage(String input);
    void onSendMessage(PropertyChangeEvent event);
}
