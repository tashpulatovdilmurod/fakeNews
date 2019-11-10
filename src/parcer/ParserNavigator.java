
package parcer;

import Model.GeneralParcelModel;
import Model.SocialNetwork;



public class ParserNavigator {
    public int navigate(String url, String fileName){
        SocialNetwork social = null;

        //FACEBOOK
        if(url.contains("facebook.com"))
            social = new FacebookParser(fileName).doParsing();
        //-------------------------------------------
        //-------------------------------------------
        
        
        //TESTING
        this.display(social);
        //TESTING
        
        return 1;
    }
    
    public GeneralParcelModel testNavigate(String url, String fileName){
        GeneralParcel general = new GeneralParcel(fileName);
        return general.doParse();
    }
    
    public void display(SocialNetwork social){
        System.out.println(social);
    }
}
