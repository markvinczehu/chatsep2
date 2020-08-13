package Chat.shared.transferobjects;

import java.io.Serializable;

public class User implements Serializable
{
    private int id;
    private String username;
    private String password;
    private String status;

    public User(String username, String password) {
        id = 0;
        this.username = username;
        this.password = password;
        status = "Online";
    }

    public int getId()
    {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus()
    {
        return status;
    }

    public String toUserList()
    {
        return username + " (" + status + ")";
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Boolean status)
    {
        if(status)
            this.status = "Online";
        else
            this.status = "Busy";
    }
}
