package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.MessageSender;
import model.Network;
import model.User;


public class Main extends Application {
	
	public static User current_user; 
	
	public static void redirect(String file,ActionEvent event) {
		try {
			Main m = new Main();
			m.r(file,event);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	private void r(String file, ActionEvent event) throws IOException {
		Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource(file));
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Client
	public static void main(String[] args) {
		Network.connect("127.0.0.1",4225);
		Network.ReceiveEmail();
		launch(args);
	}
}
