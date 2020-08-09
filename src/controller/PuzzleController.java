package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
	
	
	//remove later
	@FXML
    void mix(ActionEvent event) {
    }
	
	
	
    @FXML
    void verify(ActionEvent event) {
    	
    	Network.sendSolution(p.getByteArray());
    	
//    	if(p.verify()) {
//    		AlertHelper.informe("Correct solution");
//    	}
//    	else {
//    		AlertHelper.error("The solution is not correct!");
//    	}
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
