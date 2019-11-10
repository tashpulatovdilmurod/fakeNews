
package browser;

import Model.GeneralParcelModel;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import parcer.ParserNavigator;


public class WebBrowser {

    private GeneralParcelModel model;

    public GeneralParcelModel getModel() {
        return model;
    }

    public void setModel(GeneralParcelModel model) {
        this.model = model;
    }
    
    
public WebView addWebBrowser(Stage stage, Scene scene, String url) throws Exception{

        WebView webView = new WebView();
         
        final WebEngine webEngine = webView.getEngine();
 
        webEngine.load(url);
         
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() 
        {
            public void changed(ObservableValue<? extends State> ov, State oldState, State newState) 
            {
                
                if (newState == State.SUCCEEDED) 
                {
                    stage.setTitle(webEngine.getTitle());
                }
                if (newState == Worker.State.SUCCEEDED) {
                        Document doc = webEngine.getDocument();
                        try {
                            Transformer transformer = TransformerFactory.newInstance().newTransformer();
                            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                            
                            OutputStream  outputStream  = new FileOutputStream("D:\\abcd\\output.txt");
                            transformer.transform(new DOMSource(doc),
                                    new StreamResult(new OutputStreamWriter(outputStream, "UTF-8"))); 
                            transformer.transform(new DOMSource(doc),
                                    new StreamResult(new OutputStreamWriter(System.out, "UTF-8"))); 
                            
                           ParserNavigator parcel = new ParserNavigator();
                           GeneralParcelModel returned = parcel.testNavigate(url, "test");
                           setModel(returned);
                            
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
            }
        });
        return webView;
    }
    
    public  void doScroll(WebEngine webEngine){
        /*
        try{
            Thread.currentThread().sleep(2000);
            for(int i = 0; i < 2; i++){
                Thread.currentThread().sleep(2000);
                webEngine.executeScript("window.scrollTo(0, 200);");
            }    
        }catch(Exception e){
            System.out.println(e);
        }
        webEngine.executeScript("window.scrollTo(0, 200);");
    `   
    */
     }
}
