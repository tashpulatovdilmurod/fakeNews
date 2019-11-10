
package helloworld1;

import Model.Data;
import browser.WebBrowser;
import controller.AccordionController;
import controller.BrowserController;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HelloWorld1 extends Application {
    
    private Stage stage = null;
    private Scene scene = null;
    private List<Data> list = new ArrayList<>();
    
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.scene = new Scene(new VBox());
        
        //Display Accordion
        AccordionController a = new AccordionController(this.stage, this.scene);
        a.addAccordion();
        
        //Display Login/Registration
    }
    
    public void defineLoginButton(FXMLLoader loader, Stage stage){
        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("THE LOGIN BUTTON HAS BEEN PRESSED !!!");
            int returnedValue = new controller.LoginController().login(loader);
                if(returnedValue == 1){
                    try{
                        System.out.println("THE LOGIN WAS SUCESSFULL");
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                        Parent root = loader.load();
                        //addListenersToSliders(loader);
                        Scene scene = new Scene(root);

                        //addBrowser(loader,stage);
                        
                        stage.setScene(scene);
                        stage.show();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
        };
        Button logButton = (Button)loader.getNamespace().get("logButton");
        logButton.setOnAction(buttonHandler);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void addListenersToSliders(FXMLLoader loader){
        final Slider slider1 = (Slider)loader.getNamespace().get("slider1");
        slider1.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println("THE VALUE of the FIRST SLIDER HAS BEEN CHANGED URA !!!! "+ slider1.getValue());
            }
        });
        
        final Slider slider2 = (Slider)loader.getNamespace().get("slider2");
        slider2.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println("THE VALUE of the Second SLIDER HAS BEEN CHANGED URA !!!! "+ slider1.getValue());
            }
        });
    }
    
    public void addBrowser(String url){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("browser.fxml"));    
            final VBox vb = (VBox)loader.getNamespace().get("browser");
            new WebBrowser().addWebBrowser(this.stage,this.scene,url); 
        }catch(Exception e){
            
        }
    }

    
        
}