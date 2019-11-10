/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcer;

import Model.SocialNetwork;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 *
 * @author Dilmurod Tashpulatov
 */
public class FacebookParser{
    private Path path;
    private String data;
    private Document doc;
    private SocialNetwork social;
    
    public FacebookParser(String nameOfFile){
        this.path = Paths.get("D:\\abcd\\output.txt"); // it is for temporary use;
    }
    
    
    public SocialNetwork doParsing(){
        this.social = new SocialNetwork();
        
        //
        this.social.setUserName(this.getUserName());
        this.social.setUserContent(this.getUserContent());
        this.social.setDate(this.getDate());
        this.social.setLinks(this.getLinks());
        //
        
        //
        if(this.social.getUserName() != null)
            this.social.setUrlToUserPage(this.social.getUserName());
        //
        
        return this.social;
        
    }
    
    private void readFileToStringAndParse(){
        try{
            this.data = new String(Files.readAllBytes(this.path));
            this.doc = Jsoup.parse(data);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private String getUserContent(){
        Elements userParagraphs = this.doc.getElementsByTag("p");
        return userParagraphs.text();
    }
    
    private String getDate(){
        return doc.getElementsByClass("timeStampContent").text();
    }
    
    private String getUserName(){
        return doc.select("META[property=og:title]").attr("content").toString();
    }
    
    private List<String> getLinks(){
        List<String> links = new ArrayList<>();
        Elements a = doc.getElementsByTag("a");
            for(int i = 0; i < a.size(); i++){
                links.add(a.get(i).attr("href"));
            }
        return links;
    }

    private String getUserPageLink(String userName){
        Elements a = doc.getElementsByTag("a");
            for(int i = 0; i < a.size(); i++){
                if(a.get(i).text().contains(userName)){
                    return a.get(i).attr("href");
                }
            }
        return null;
    }

    private void parse(){
        /*try{
            
            Document doc = Jsoup.parse(data);
            Elements a = doc.getElementsByTag("a");
            for(int i = 0; i < a.size(); i++){
                if(a.get(i).text().contains(userName)){
                    System.out.println("\n #FOUND "+a.get(i).attr("href"));
                    break;
                }
                //System.out.println("\nTHE HREF "+i+" => "+a.get(i).text()+"\n#######");
            }
            //System.out.println("\n THE LOCATION IS :: "+pageLocation);
            
            Elements img = doc.getElementsByClass("scaledImageFitWidth");
            for(int i = 0; i < img.size(); i++){
                    System.out.println("\n #FOUND IMG => "+img.get(i).attr("src"));
                //System.out.println("\nTHE HREF "+i+" => "+a.get(i).text()+"\n#######");
            }
            
            //webEngine.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            
        }catch(Exception e){
            System.out.println(e);
        }
    */
    }
}
