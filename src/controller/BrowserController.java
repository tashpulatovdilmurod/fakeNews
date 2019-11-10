package controller;

import browser.WebBrowser;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class BrowserController implements java.io.Serializable{
    private Stage stage;
    private Scene scene;
    
    private WebBrowser browser;
    
    public BrowserController(Stage stage, Scene scene) {
        this.stage = stage;
        this.scene = scene;
    }
    
    public BrowserController(Stage stage) {
        this.stage = stage;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("browser.fxml"));
            Parent root = loader.load();
            Scene sc = new Scene(root);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void displayTheBrowserPage(String url){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("browser.fxml"));
            Parent root = loader.load();
            final VBox vb = (VBox)loader.getNamespace().get("browser");
            
            StackPane stack = new StackPane();
            
            // Set the Style-properties of the VBox
            stack.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 5;" +
                    "-fx-border-radius: 5;" +
                    "-fx-border-color: blue;");
            
            this.browser = new WebBrowser();
            
            stack.getChildren().add(browser.addWebBrowser(stage, scene, url));
            
            vb.getChildren().add(stack);
            
            this.scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.show();
            
            //browser_submit
            Button btn = (Button)loader.getNamespace().get("browser_submit");
            
            EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                         Slider slider1 = (Slider)loader.getNamespace().get("browser_slider1");
                         Slider slider2 = (Slider)loader.getNamespace().get("browser_slider2");
                         browser.getModel().setBvalue(Math.round(slider1.getValue())+"");
                         browser.getModel().setKvalue(Math.round(slider2.getValue())+"");
                         AccordionController acc = new AccordionController(stage, scene);                        
                         acc.addAccordionWithGeneralParcelModel(browser.getModel());
                    }
            };
            btn.setOnAction(buttonHandler);
            //
            Slider slider1 = (Slider)loader.getNamespace().get("browser_slider1");
            Text text_slider1 = (Text)loader.getNamespace().get("browser_slider_text1");
            
            slider1.valueProperty().addListener( 
             new ChangeListener<Number>() { 
  
                public void changed(ObservableValue <? extends Number >  
                          observable, Number oldValue, Number newValue) 
                { 

                    text_slider1.setText("value: " + Math.round(newValue.doubleValue())); 
                } 
            });
            
            Slider slider2 = (Slider)loader.getNamespace().get("browser_slider2");
            Text text_slider2 = (Text)loader.getNamespace().get("browser_slider_text2");
            
            slider2.valueProperty().addListener( 
             new ChangeListener<Number>() { 
  
                public void changed(ObservableValue <? extends Number >  
                          observable, Number oldValue, Number newValue) 
                { 
                    text_slider2.setText("value: " + Math.round(newValue.doubleValue())); 
                } 
            });
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
