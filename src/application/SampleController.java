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
    	Network.connect("localhost", Main.current_user.serverPort);
    	//Network.Receive();
    	System.out.println("Connected to ip: "+Network.Host+", Port: "+Network.port);
    	if(Main.current_user != null) {
    		Main.redirect("Inbox.fxml", event);
    	}
    }
}
