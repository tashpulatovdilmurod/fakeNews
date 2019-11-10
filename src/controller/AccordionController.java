package controller;

import Model.Data;
import Model.GeneralParcelModel;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AccordionController implements java.io.Serializable{
    private Stage stage;
    private Scene scene;
    private List<Data> list = new ArrayList<>();

    public AccordionController(Stage stage, Scene scene) {
        this.stage = stage;
        this.scene = scene;
    }
    
    public void addAccordion(){
        try{
            
            BrowserController browser = new BrowserController(this.stage, this.scene);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("accordion.fxml"));
            Parent root = loader.load();
            
            this.list = new JsonExtracter.ParseJson().parse();
            
            Accordion accordion = new Accordion();
            accordion.setMaxWidth(600);
            for(Data data : list){
                Text text1 = new Text(); 
                text1.setText("Author => "+ reduceLength(data.getAuthor()));
                Text text2 = new Text();
                text2.setText("Claim => "+ reduceLength(data.getClaim()));
                Text text3 = new Text();
                text3.setText("Claim_url => "+ reduceLength(data.getClaim_url()));
                Hyperlink link = new Hyperlink(data.getClaim_url());
                Text text4 = new Text();
                text4.setText("Date => "+ reduceLength(data.getDate()));
                Text text5 = new Text();
                text5.setText("Label => "+ reduceLength(data.getLabel()));
                Text text6 = new Text();
                text6.setText("Url => "+ reduceLength(data.getUrl()));
                
                EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        browser.displayTheBrowserPage(data.getClaim_url());
                    }
                 };
                
                Button btn = new Button();
                btn.setText("View");
                btn.setOnAction(buttonHandler);
                
                VBox vbNew = new VBox();
                
                vbNew.getChildren().addAll(text1,text2,text3,link,text4,text5,text6,btn);
               
                TitledPane pane1 = new TitledPane(reduceLength(data.getClaim()) , vbNew);
                
                
                accordion.getPanes().add(pane1);
            }    
            
            VBox vBox = (VBox)loader.getNamespace().get("vb_accordion");
            vBox.getChildren().add(accordion);

            
            this.scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.show();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public void addAccordionWithGeneralParcelModel(GeneralParcelModel model){
        try{
            
            BrowserController browser = new BrowserController(this.stage, this.scene);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("accordion.fxml"));
            Parent root = loader.load();
            
            
            
            
            Accordion accordion = new Accordion();
            accordion.setMaxWidth(600);
            
            
            //-----------------------
            VBox vb = new VBox();
            Text t = new Text();
            t.setText(model.getTitle());
            t.wrappingWidthProperty();
            t.setWrappingWidth(500);
            vb.getChildren().add(t);
            
            
            TitledPane pane10 = new TitledPane("TITLE" , vb);
            accordion.getPanes().add(pane10);
            
            //---------------------------------------------------------------
            VBox vb1 = new VBox();
            Text t1 = new Text();
            t1.setText("BELIVERITY => "+model.getBvalue());
            Text t2 = new Text();
            t2.setText("KNOWLEDGE => "+model.getKvalue());
            vb1.getChildren().addAll(t1,t2);
            
            
            TitledPane pane1101 = new TitledPane("PROVIDED DETAILS" , vb1);
            accordion.getPanes().add(pane1101);
            
            //---------------------------------------------------------------
            
            TitledPane pane11 = new TitledPane("HEADERS" , this.extractGeneralModelLists(model.getHeaders(), false));
            accordion.getPanes().add(pane11);
            
            TitledPane panel2 = new TitledPane("PARAGRAPHS" , this.extractGeneralModelLists(model.getParagraphs(), false));
            accordion.getPanes().add(panel2);
            
            TitledPane panel3 = new TitledPane("LINKS" , this.extractGeneralModelLists(model.getLinks(), true));
            accordion.getPanes().add(panel3);
            
            TitledPane panel4 = new TitledPane("IMAGES" , this.extractGeneralModelLists(model.getImages(), true));
            accordion.getPanes().add(panel4);
            
            TitledPane panel5 = new TitledPane("VIDEOS" , this.extractGeneralModelLists(model.getVideos(), true));
            accordion.getPanes().add(panel5);
            
            //-----------------------
            
            VBox vBox = (VBox)loader.getNamespace().get("vb_accordion");
            vBox.getChildren().add(accordion);
            
            
            this.scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.show();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    private ScrollPane extractGeneralModelLists(List<String> list, Boolean hyperLink){
        ScrollPane scrollPane = new ScrollPane();
        VBox vb = new VBox();
        if(hyperLink){
            for(String s : list){
                Separator sepHor = new Separator();
                Hyperlink  t = new Hyperlink (s);
                t.setOnAction((ActionEvent event) -> {
                    String url = t.getText();
                    //
                    Stage asdfasdf = new Stage();
                    //
                    BrowserController b = new BrowserController(asdfasdf);
                    b.displayTheBrowserPage(url);
                });
                t.setWrapText(true);
                vb.getChildren().addAll(sepHor,t);
            }
        }
        else{
            for(String s : list){
                Separator sepHor = new Separator();
                Text t = new Text(s);
                t.wrappingWidthProperty();
                t.setWrappingWidth(500);
                vb.getChildren().addAll(sepHor,t);
            }
        }
        scrollPane.setContent(vb);
        return scrollPane;
    }
    
    private String reduceLength(String str){
        if(str != null && str.length() > 90){
           return str.substring(0,87).concat("...");
        }
        else{
            return str;
        }
    }
    
}
