package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.SafeBox;

public class SafeBoxControllerGUI {

    @FXML
    private Label labSafe;

    @FXML
    private Button btOpen;

    @FXML
    private TextField txtBox1;

    @FXML
    private TextField txtBox2;

    @FXML
    private TextField txtBox3;

    @FXML
    private TextField txtBox4;

    @FXML
    private TextField txtBox5;

    @FXML
    private TextField txtBox6;

    @FXML
    private Label labInfo1;

    	//SafeBox2
    
    @FXML
    private Button btChangePass;

    @FXML
    private Label labInfo2;

    @FXML
    private TextArea txtBoxInsides;

    @FXML
    private Button btClose;
    
    // SafeBox3
    
    @FXML
    private TextField txtPass1;

    @FXML
    private TextField txtPass2;

    @FXML
    private TextField txtPass3;

    @FXML
    private TextField txtPass4;

    @FXML
    private TextField txtPass5;

    @FXML
    private TextField txtPass6;

    @FXML
    private Label labInfo3;

    @FXML
    private TextField txtNewPass1;

    @FXML
    private TextField txtNewPass2;

    @FXML
    private TextField txtNewPass3;

    @FXML
    private TextField txtNewPass4;

    @FXML
    private TextField txtNewPass5;

    @FXML
    private TextField txtNewPass6;

    @FXML
    private Label labInfo4;
    
    @FXML
    private Label warning;

    private Stage mainStage;

    public Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}

	@FXML
    void switchWindow(ActionEvent event) throws IOException {
		
		String currentPass = txtBox1.getText() + txtBox2.getText() + txtBox3.getText() + txtBox4.getText() + txtBox5.getText() + txtBox6.getText();
		
		if(currentPass.matches("[0-9]{6}")) {
			double pass = Double.parseDouble(currentPass);
			if(SafeBox.unlockSafe(pass)==true) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SafeBox2.fxml"));
				fxmlLoader.setController(this);
				Parent root = fxmlLoader.load();
				Scene scene = new Scene(root);
				
				txtBoxInsides.setText(SafeBox.safeBoxInsides);
				
				mainStage.setScene(scene);
				mainStage.setTitle("SafeBox");
				mainStage.show();
			}
			
			else {
				warning.setText("Clave incorrecta");
			}
		}
		
		else {
			warning.setText("Introduzca un # por espacio");
		}
	}
	
	@FXML
	void changeToPassWindow(ActionEvent event) throws IOException {
		
		String safeContents= txtBoxInsides.getText();
    	if(safeContents.equals(SafeBox.safeBoxInsides)) {
    		FXMLLoader fxmlLoader = new  FXMLLoader(getClass().getResource("SafeBox3.fxml"));
        	fxmlLoader.setController(this);
        	Parent root = fxmlLoader.load();
        	Scene scene = new Scene(root);
        	
        	mainStage.setScene(scene);
        	mainStage.setTitle("Safe Box");
        	mainStage.show();
    	}
    	else {
    		txtBoxInsides.setText(SafeBox.safeContents(safeContents));
    		FXMLLoader fxmlLoader = new  FXMLLoader(getClass().getResource("SafeBox3.fxml"));
        	fxmlLoader.setController(this);
        	Parent root = fxmlLoader.load();
        	Scene scene = new Scene(root);
        	
        	mainStage.setScene(scene);
        	mainStage.setTitle("Safe Box");
        	mainStage.show();
    	}
    	
	}
	
	@FXML
    void closeWindow(ActionEvent event) throws IOException {
    	String safeContents= txtBoxInsides.getText();
    	if(safeContents.equals(SafeBox.safeBoxInsides)) {
    		FXMLLoader fxmlLoader = new  FXMLLoader(getClass().getResource("SafeBox1.fxml"));
        	fxmlLoader.setController(this);
        	Parent root = fxmlLoader.load();
        	Scene scene = new Scene(root);
        	
        	mainStage.setScene(scene);
        	mainStage.setTitle("Safe Box");
        	mainStage.show();
    	}
    	else {
    		txtBoxInsides.setText(SafeBox.safeContents(safeContents));
        	FXMLLoader fxmlLoader = new  FXMLLoader(getClass().getResource("SafeBox1.fxml"));
        	fxmlLoader.setController(this);
        	Parent root = fxmlLoader.load();
        	Scene scene = new Scene(root);
        	
        	mainStage.setScene(scene);
        	mainStage.setTitle("Safe Box");
        	mainStage.show();
    	}
    }

	@FXML
	void changePassBTMWindow(ActionEvent event)  throws IOException {
  	
		String currentPass = txtPass1.getText() + txtPass2.getText() + txtPass3.getText() + txtPass4.getText() + txtPass5.getText() + txtPass6.getText();
		String newPass = txtNewPass1.getText() + txtNewPass2.getText() + txtNewPass3.getText() + txtNewPass4.getText() + txtNewPass5.getText() + txtNewPass6.getText();
		if(currentPass.matches("[0-9]{6}") && newPass.matches("[0-9]{6}")) {
			double pass = Double.parseDouble(currentPass);
			double newPassword = Double.parseDouble(newPass);
			if(SafeBox.unlockSafe(pass)==true && SafeBox.samePasswords(newPassword)==false) {
				SafeBox.currentPass=newPassword;
				warning.setText("Clave actualizada!");
			}
			
			else if (SafeBox.samePasswords(newPassword)==true) {
				warning.setText("Introduzca una clave distinta a la antigua");
			}
			
			else {
				warning.setText("Clave incorrecta");
			}
		}
		
		else {
			warning.setText("Introduzca un # por espacio");
		}
			
    }
	
  @FXML
    void closePassWindow(ActionEvent event) throws IOException {
	  FXMLLoader fxmlLoader = new  FXMLLoader(getClass().getResource("SafeBox1.fxml"));
  	fxmlLoader.setController(this);
  	Parent root = fxmlLoader.load();
  	Scene scene = new Scene(root);
  	
  	mainStage.setScene(scene);
  	mainStage.setTitle("Safe Box");
  	mainStage.show();
    }
	
}
