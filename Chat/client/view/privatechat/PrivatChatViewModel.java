package Chat.client.view.privatechat;

import Chat.client.model.privatechat.PrivateChatModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class PrivatChatViewModel {

    private PrivateChatModel privateChatModel;
    private StringProperty messageField;
    private StringProperty chatArea;

    public PrivatChatViewModel(PrivateChatModel privateChatModel) {
        this.privateChatModel = privateChatModel;
        messageField = new SimpleStringProperty();
        chatArea = new SimpleStringProperty();
        privateChatModel.addListener("SendMessage", this::onSendMessage);
    }

    private void onSendMessage(PropertyChangeEvent event) {
        chatArea.setValue(event.getNewValue().toString());
        System.out.println("arrived at view model");
    }

    public void sendMessage()
    {
        String input = messageField.get();
        if(!input.equals(""))
        {
            privateChatModel.sendMessage(input);
        }
        else{
            messageField.setValue("Please enter a message");
        }
    }

    public StringProperty messageField()
    {
        return messageField;
    }

    public StringProperty chatArea()
    {
        return chatArea;
    }
}
