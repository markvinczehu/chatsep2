package Chat.client.view.commonchat;

import Chat.client.model.commonchat.CommonChatModel;
import Chat.shared.transferobjects.Message;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class CommonChatViewModel
{
  private CommonChatModel commonChatModel;
  private StringProperty messageField;
  private StringProperty chatArea;
  private ListProperty<String> activeUsersList;

  public CommonChatViewModel(CommonChatModel commonChatModel)
  {
    this.commonChatModel = commonChatModel;
    messageField = new SimpleStringProperty();
    chatArea = new SimpleStringProperty();
    activeUsersList = new SimpleListProperty<String>();
    commonChatModel.addListener("SendMessage", this::onSendMessage);
  }

  private void onSendMessage(PropertyChangeEvent event)
  {
    chatArea.setValue(event.getNewValue().toString());
    System.out.println("arrived at view model");
  }

  public void sendMessage()
  {
    String input = messageField.get();
    if(!input.equals("") && input!=null)
    {
      commonChatModel.sendMessage(input);
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

  public ListProperty<String> activeUsersList() { return activeUsersList; }

}