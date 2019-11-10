/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

/**
 *
 * @author Dilmurod Tashpulatov
 */
public class LoginController {
    public int login(FXMLLoader loader){
        TextField email = (TextField)loader.getNamespace().get("email");
        TextField pass = (TextField)loader.getNamespace().get("pass");
        
        if(email.getText().equals("email") && pass.getText().equals("pass")){
            return 1;
        }
        return 0;
    }
}
