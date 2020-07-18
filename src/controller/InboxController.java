package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Message;

public class InboxController implements Initializable{
	@FXML
    private TableView<Message> tb;

    @FXML
    private TableColumn<Message, String> cl;

    @FXML
    private Text txt;
    
    @FXML
    private Label mail;


    @FXML
    private Text subject;
    
    @FXML
    void compose(ActionEvent event) {
    	Main.redirect("Compose.fxml", event);
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		mail.setText(Main.current_user.email);
		cl.setCellValueFactory(new PropertyValueFactory<Message, String>("sender"));
		Main.current_user.addMessage("moudi.hijazi98@gmail.com", "Info 408 project", "Hello\n where is the project.\n Regards ..");
		Main.current_user.addMessage("lolo@gmail.com", "...", "Hello\n I love pasta ..");
		Main.current_user.addMessage("trump@hotmail.com", "Election", "Hello\nwhat do i have to do to win the next election\nplease answer..");
		Main.current_user.addMessage("super_hodhod@hotmail.com", "", "Hello\n I am noob");

		
		ObservableList<Message> msg = Main.current_user.getMessages();
		tb.getItems().setAll(msg);
		
	}
	
	@FXML
    void changeSellection(MouseEvent event) {
		Message msg = tb.getSelectionModel().getSelectedItem();
		
		if(msg != null) {
			subject.setText("Subject: "+msg.subject);
			txt.setText(msg.body);
		}
    }

}
