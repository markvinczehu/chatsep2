package Chat.client;

import Chat.client.core.ClientFactory;
import Chat.client.core.ModelFactory;
import Chat.client.core.ViewHandler;
import Chat.client.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class StartClient extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ClientFactory cf = new ClientFactory();
    ModelFactory mf = new ModelFactory(cf);
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);
    vh.start();
  }
}
