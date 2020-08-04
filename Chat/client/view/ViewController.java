package Chat.client.view;

import Chat.client.core.ViewHandler;
import Chat.client.core.ViewModelFactory;

import java.sql.SQLException;

public interface ViewController
{
  void init(ViewHandler vh, ViewModelFactory vmf) throws SQLException;
}
