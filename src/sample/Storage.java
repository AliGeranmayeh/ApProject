package sample;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Storage {

    private Integer id;
    private String userName;
    private String password;
    private String confirmpassword;

    public Storage(TextField textField, PasswordField passField){this("","");}

    public Storage(String userName, String password){
        this.userName= userName;
        this.password= password;
    }

    public Storage() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
}
