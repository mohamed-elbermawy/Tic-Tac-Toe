/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mohamed
 */
public class Redirection {
    
    private Stage stage;
    
    void redirction(String fxmlPageName,ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPageName));
        Scene scene = new Scene(root);

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    void closePages(ActionEvent event){
       stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       stage.close();
    }
}
