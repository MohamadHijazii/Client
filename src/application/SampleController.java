package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Network;
import model.User;

public class SampleController {
	@FXML
    private TextField email;

    @FXML
    private TextField pwd;

    @FXML
    void login(ActionEvent event) {
    	String _email = email.getText();
    	String _pwd = pwd.getText();
    	Main.current_user = User.getUserWith(_email, _pwd);
    	Network.connect(Main.current_user.serverip, Main.current_user.serverPort);
    	Network.serverName = Main.current_user.serverName;
    	Network.Receive();
    	System.out.println("Connected to name: "+Network.serverName+", ip: "+Network.ip+", Port: "+Network.port);
    	if(Main.current_user != null) {
    		Main.redirect("Inbox.fxml", event);
    	}
    }
}
