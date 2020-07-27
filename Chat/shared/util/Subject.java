package Chat.shared.util;

import java.beans.PropertyChangeListener;

public interface Subject {
    void addListener(String evtName, PropertyChangeListener listener);
    void removeListener(String evtName, PropertyChangeListener listener);
}
