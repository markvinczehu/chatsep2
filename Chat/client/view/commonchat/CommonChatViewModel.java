package Chat.client.view.commonchat;

import Chat.client.model.commonchat.CommonChatModel;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CommonChatViewModel
{
  private CommonChatModel commonChatModel;
  private StringProperty messageField;
  private StringProperty chatArea;
  private ListProperty activeUsersList;

  public CommonChatViewModel(CommonChatModel commonChatModel)
  {
    this.commonChatModel = commonChatModel;
    messageField = new SimpleStringProperty();
    chatArea = new SimpleStringProperty();
    activeUsersList = new SimpleListProperty();
  }

  public void sendMessage()
  {
    commonChatModel.sendMessage();
  }

  public StringProperty messageField()
  {
    return messageField;
  }

  public StringProperty chatArea()
  {
    return chatArea;
  }

  public ListProperty activeUsersList() { return activeUsersList; }

}