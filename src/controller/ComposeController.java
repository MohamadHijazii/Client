package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.MessageSender;
import model.Network;
import model.Puzzle;

public class ComposeController {
	@FXML
    private TextField to;

    @FXML
    private TextField subject;

    @FXML
    private TextArea body;
    
    

    @FXML
    void goToInbox(ActionEvent event) {
    	Main.redirect("Inbox.fxml", event);
    }

    @FXML
    void send(ActionEvent event) {
    	Network.SendMessage(to.getText(),subject.getText(),body.getText());
    	byte []p = Network.waitForPuzzle();
    	PuzzleController.p = new Puzzle(p);
    	Main.redirect("Puzzle.fxml", event);
    }

}
