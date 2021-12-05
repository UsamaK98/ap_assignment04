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


public class CalculatorController implements Initializable {
	
	@FXML
    private TextField txt_result;
    String op ="";
    long number1;
    long number2;
  
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    }
    
    //First Method
    public void Number (ActionEvent ae){
        String no = ((Button)ae.getSource()).getText();
        txt_result.setText(txt_result.getText()+no);
    }
    
    // Second Method
    public void Operation (ActionEvent ae){
    
        String operation = ((Button)ae.getSource()).getText();
        if (!operation.equals("=")){      
            if(!op.equals("")){
                return;
            }
            op = operation;
            number1 = Long.parseLong(txt_result.getText());
            txt_result.setText("");
        }else {       
            if(op.equals("")){
                return;
            }
            number2 = Long.parseLong(txt_result.getText());
            calculate(number1, number2, op);
            op="";
        }
    }  
    
    // Third Method
    public void calculate (long n1, long n2, String op){
    
        switch (op){
        
            case "+" : txt_result.setText(n1 + n2 + "");break;
            case "-" : txt_result.setText(n1 - n2 + "");break;
            case "*" : txt_result.setText(n1 * n2 + "");break;
            case "/" : 
                if (n2 == 0){
                txt_result.setText("0");break;
                }
                txt_result.setText(n1/n2+ "");break;  
        }
    }
    
    public void goBackToMainMenu (ActionEvent event) throws IOException {
		
		Parent MainMenuView = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Scene MainMenuViewScene = new Scene (MainMenuView);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(MainMenuViewScene);
		window.show();
	}
}