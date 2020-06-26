import java.io.Serializable;

public class AllUserLogin implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String Email;
    private String Password;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
        System.out.println(Email+"all login");
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}