package Chat.client.view.privatechat;

import Chat.client.model.privatechat.PrivateChatModel;
import Chat.shared.transferobjects.UserInfo;
import Chat.shared.transferobjects.PrivateMessage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class PrivateChatViewModel
{

    private PrivateChatModel privateChatModel;
    private StringProperty messageField;
    private StringProperty chatArea;
    private UserInfo currentUser;
    private UserInfo toUser;

    public PrivateChatViewModel(PrivateChatModel privateChatModel) {
        this.privateChatModel = privateChatModel;
        messageField = new SimpleStringProperty();
        chatArea = new SimpleStringProperty();
        currentUser = privateChatModel.getCurrentUser();
        toUser = privateChatModel.getToUser();
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
            PrivateMessage pm = new PrivateMessage(currentUser.getId(), toUser.getId(), input);
            privateChatModel.sendMessage(pm);
            chatArea.setValue(pm.getDate() + " - " + currentUser.getUsername() + ": " + pm.getMsg());
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

  public ArrayList<PrivateMessage> getMessageLog()
  {
      return privateChatModel.getMessageLog();
  }
}
