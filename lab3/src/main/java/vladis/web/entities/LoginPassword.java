package vladis.web.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loginpassword")
public class LoginPassword {

    @Id
    private String login;
    private String password;

    public LoginPassword() {
    }

    public LoginPassword(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){
        return  password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString(){
        return "login: " + login;
    }
}