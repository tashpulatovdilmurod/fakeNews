package parcer;

import Model.GeneralParcelModel;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class GeneralParcel implements java.io.Serializable{
    private GeneralParcelModel model;
    private Path path;
    private Document doc;
    private String data;
     
   public GeneralParcel(String nameOfFile){
        try{
            this.path = Paths.get("D:\\abcd\\output.txt"); // it is for temporary use;
            this.data = new String(Files.readAllBytes(this.path));
            this.doc = Jsoup.parse(data);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
   
   public GeneralParcelModel doParse(){
       this.model = new GeneralParcelModel();
       model.setTitle(doc.getElementsByTag("title").text());
       model.setHeaders(this.getHeaders());
       model.setParagraphs(this.getNodes("p"));
       model.setLinks(this.getNodes("a"));
       model.setImages(this.getNodes("img"));
       model.setVideos(this.getNodes("video"));
       return this.model;
   }
    
    private List<String> getHeaders(){
        String[] headers = {"h1","h2","h3","h4","h5","h6"};
        List<String> returnList = new ArrayList<>();
        for(String header : headers){
            Elements ps = doc.getElementsByTag(header);
            for(int i = 0; i < ps.size(); i++){
                String data = ps.get(i).text();
                if(data.length() != 0)
                    returnList.add(data);
            }
        }
        return returnList;
    }
    private List<String> getNodes(String tag){
        List<String> returnList = new ArrayList<>();
        Elements ps = doc.getElementsByTag(tag);
        if(tag.contains("a")){
            for(int i = 0; i < ps.size(); i++){
                String data = ps.get(i).attr("href");
                if(this.isValidURL(data))
                    returnList.add(data);
            }
        }
        else if(tag.contains("img")){
            for(int i = 0; i < ps.size(); i++){
                String data = ps.get(i).attr("src");
                if(this.isValidURL(data))
                    returnList.add(data);
            }
        }
        else{
            for(int i = 0; i < ps.size(); i++){
                String data = ps.get(i).text();
                if(data.length() != 0)
                    returnList.add(data);
                }
        }
        return returnList;
    } 
    
    public boolean isValidURL(String url) {  

    URL u = null;

    try {  
        u = new URL(url);  
    } catch (MalformedURLException e) {  
        return false;  
    }

    try {  
        u.toURI();  
    } catch (URISyntaxException e) {  
        return false;  
    }  

    return true;  
} 
}
