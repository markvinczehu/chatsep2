package Chat.client.view.commonchat;

import Chat.client.model.commonchat.CommonChatModel;
import Chat.shared.networking.User;
import Chat.shared.networking.UserInfo;
import Chat.shared.transferobjects.Message;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class CommonChatViewModel
{
  private CommonChatModel commonChatModel;
  private StringProperty messageField;
  private StringProperty chatArea;
  private ObservableList<String> allUsersList;
  private UserInfo currentUser;


  public CommonChatViewModel(CommonChatModel commonChatModel)
  {
    this.commonChatModel = commonChatModel;
    messageField = new SimpleStringProperty();
    chatArea = new SimpleStringProperty();
    allUsersList = FXCollections.observableArrayList();
    commonChatModel.addListener("SendMessage", this::onSendMessage);
    commonChatModel.addListener("UsersList", this::onUserList);
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
      Message message = new Message(currentUser.getUsername(), input);
      commonChatModel.sendMessage(message);
    }
    else{
      messageField.setValue("Please enter a message");
    }
  }

  private void onUserList(PropertyChangeEvent event)
  {
    ArrayList<String> list = (ArrayList<String>) event.getNewValue();
    //String user = commonChatModel.getCurrentUser().getUsername();
    list.removeIf(item -> item.equals(currentUser.getUsername()));
    allUsersList.removeAll();
    allUsersList.addAll(list);
    System.out.println("back to viewmodel");
  }

  public void getUserList()
  {
    commonChatModel.getUserList();
  }

  public void onClickUser()
  {

  }

  public StringProperty messageField()
  {
    return messageField;
  }

  public StringProperty chatArea()
  {
    return chatArea;
  }

  public ObservableList<String> allUsersList() { return allUsersList; }

  public void getUserInfo(String username)
  {
    commonChatModel.getUserInfo(username);
  }

  public void getCurrentUser()
  {
    currentUser = commonChatModel.getCurrentUser();
  }

  public boolean getGuestUser()
  {
    return commonChatModel.getGuestUser();
  }

  public void logOutUser()
  {
    commonChatModel.logoutUser();
  }
}