package controller;

import javafx.scene.control.Alert;

public class AlertHelper {
	
	public static void error(String context){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(context);
        alert.show();
    }

    public static void informe(String context){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(context);
        alert.show();
    }

}
