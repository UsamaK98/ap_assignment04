package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CurrencyConverterController implements Initializable {
    
    CurrencyConverter c;
    
    @FXML
    private Label label;
    
    @FXML
    private TextField userInput;
    
    @FXML
    private ChoiceBox leftChoicebox;
    
    @FXML
    private ChoiceBox rightChoicebox;

    /**
     * when the "Swap" button is clicked, it will swap the currency on the left-side and the right-side
     * @param event 
     */
    @FXML
    private void handleSwapping(ActionEvent event) {
        String leftValue = leftChoicebox.getValue().toString();
        String rightValue = rightChoicebox.getValue().toString();
        if(!leftValue.equals(rightValue)) {
            leftChoicebox.setValue(rightValue);
            rightChoicebox.setValue(leftValue);
        }
    }
    
    @FXML
    public void goBackToMainMenu (ActionEvent event) throws IOException {
		
		Parent MainMenuView = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Scene MainMenuViewScene = new Scene (MainMenuView);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(MainMenuViewScene);
		window.show();
	}
    
    /**
     * when the "Convert" button is clicked, it will convert the user input on the left-side to the currency on the right-side
     * @param event 
     */
    @FXML
    private void handleConversion(ActionEvent event){
        String leftCur = leftChoicebox.getValue().toString();
        String leftValueTxt = userInput.getText();
        double leftValue = Double.parseDouble(leftValueTxt);
        String rightCur = rightChoicebox.getValue().toString();
        double result = c.currencyConversion(leftCur, rightCur, leftValue);
        String resultTxt = String.format("%.2f", result);
        label.setText(resultTxt);
    }
    
    /**
     * when the "Reset" button is clicked, it will reset the user input on the left-side to 1 and convert to the currency on the right-side
     * @param event 
     */
    @FXML
    private void handleReset(ActionEvent event){
        userInput.setText("1");
        String leftCur = leftChoicebox.getValue().toString();
        String rightCur = rightChoicebox.getValue().toString();
        double result = c.currencyConversion(leftCur, rightCur, 1);
        String resultTxt = String.format("%.2f", result);
        label.setText(resultTxt);     
    }
    
    /**
     * initialize the user input to 1 when application started and limited user input to decimal number
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c = new CurrencyConverter();
        userInput.setText("1");
        userInput.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,9}([\\.]\\d{0,9})?")) {
                    userInput.setText(oldValue);
                }
            }
        });
    }       
}