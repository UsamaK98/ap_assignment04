package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainMenuController implements Initializable {
	
	public void switchToCalculator (ActionEvent event) throws IOException {
		
		Parent MainMenuView = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene MainMenuViewScene = new Scene (MainMenuView);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(MainMenuViewScene);
		window.show();
	}
	
	public void switchToCurrencyConverter (ActionEvent event) throws IOException {
		 	Parent CurrencyConverter = FXMLLoader.load(getClass().getResource("CurrencyConverter.fxml"));
	        Scene scene = new Scene(CurrencyConverter);
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        String css = this.getClass().getResource("style.css").toExternalForm();
	        scene.getStylesheets().add(css);
	        window.setScene(scene);
	        window.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
