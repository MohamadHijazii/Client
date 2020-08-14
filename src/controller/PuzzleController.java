package controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Network;
import model.Puzzle;

public class PuzzleController implements Initializable{
	
	public static Puzzle p;
	
    @FXML
    private AnchorPane pane;

    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setChars();
		
	}
	
	public void setChars() {
		ObservableList<Node> nodes = pane.getChildren();
		for(int i=0;i<36;i++) {
			Label l = (Label)nodes.get(i);
			l.setText(p.charAt(i)+"");
		}
	}
	
	
	
    @FXML
    void verify(ActionEvent event) {
    	
    	Network.sendSolution(p.getByteArray());
    	String s = null;
    	HashMap<Boolean, String> h = Network.WaitForResult();
    	boolean res = h.containsKey(true);
    	s = (String)h.get(res);
    	
    	if(res) {
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setContentText(s);
	        Optional<ButtonType> result = alert.showAndWait();
	        if(result.get() == ButtonType.OK) {
	        	Main.redirect("Inbox.fxml", event);
	        }
    	}
    	else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(s);
            alert.show();
    	}
    }
	
	
	
	
	
	@FXML
    void b0(ActionEvent event) {
		p.move(0);
		setChars();
    }

    @FXML
    void b1(ActionEvent event) {
    	p.move(1);
    	setChars();
    }

    @FXML
    void b2(ActionEvent event) {
    	p.move(2);
    	setChars();
    }

    @FXML
    void b3(ActionEvent event) {
    	p.move(3);
    	setChars();
    }

    @FXML
    void b4(ActionEvent event) {
    	p.move(4);
    	setChars();
    }

    @FXML
    void b5(ActionEvent event) {
    	p.move(5);
    	setChars();
    }

    @FXML
    void b6(ActionEvent event) {
    	p.move(6);
    	setChars();
    }

    @FXML
    void b7(ActionEvent event) {
    	p.move(7);
    	setChars();
    }

    @FXML
    void b8(ActionEvent event) {
    	p.move(8);
    	setChars();
    }

    
    

}
