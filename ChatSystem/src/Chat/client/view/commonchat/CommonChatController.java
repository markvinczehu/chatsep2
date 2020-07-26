package Chat.client.view.commonchat;

import Chat.client.core.ViewHandler;
import Chat.client.core.ViewModelFactory;
import Chat.client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CommonChatController implements ViewController
{
  @FXML private TextField messageField;
  @FXML private TextArea commonChatArea;

  private CommonChatViewModel commonChatViewModel;
  private ViewHandler viewHandler;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    viewHandler = vh;
    commonChatViewModel = vmf.getCommonChatViewModel();
    //messageField.textProperty().bindBidirectional();
    //commonChatArea.textProperty().bindBidirectional();
  }

  public void onSendButton(ActionEvent actionEvent)
  {
  }
}