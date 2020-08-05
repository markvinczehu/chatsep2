package Chat.client.view.commonchat;

import Chat.client.model.commonchat.CommonChatModel;
import Chat.shared.networking.User;
import Chat.shared.transferobjects.Message;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class CommonChatViewModel
{
  private CommonChatModel commonChatModel;
  private StringProperty messageField;
  private StringProperty chatArea;
  private ObservableList<User> activeUsersList;

  public CommonChatViewModel(CommonChatModel commonChatModel)
  {
    this.commonChatModel = commonChatModel;
    messageField = new SimpleStringProperty();
    chatArea = new SimpleStringProperty();
    activeUsersList = FXCollections.observableArrayList();
    commonChatModel.addListener("SendMessage", this::onSendMessage);
    commonChatModel.addListener("ActiveUsers", this::onActiveUsers);
  }

  private void onSendMessage(PropertyChangeEvent event)
  {
    chatArea.setValue(event.getNewValue().toString());
    System.out.println("arrived at view model");
  }


  public void sendMessage()
  {
    String input = messageField.get();
    if(!input.equals(""))
    {
      commonChatModel.sendMessage(input);
    }
    else{
      messageField.setValue("Please enter a message");
    }
  }

  private void onActiveUsers(PropertyChangeEvent event)
  {
    ArrayList<User> list = (ArrayList<User>) event.getNewValue();
    User user = commonChatModel.getCurrentUser();
    list.removeIf(item -> item.equals(user));
    activeUsersList.addAll(list);
    System.out.println("back to viewmodel");
  }

  public void getUserList()
  {
    commonChatModel.getUserList();
  }

  public StringProperty messageField()
  {
    return messageField;
  }

  public StringProperty chatArea()
  {
    return chatArea;
  }

  public ObservableList<User> activeUsersList() { return activeUsersList; }

}