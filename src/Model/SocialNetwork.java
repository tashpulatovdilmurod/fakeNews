package Model;

import java.util.ArrayList;
import java.util.List;


public class SocialNetwork implements java.io.Serializable{
    private String userName;
    private String userContent;
    private String date;
    private String urlToUserPage;
    private List<GraphicContent> graphicContentsList = new ArrayList<>();
    private List<String> links = new ArrayList<>();

    public SocialNetwork() {
    }

    public SocialNetwork(String userName, String userContent, String date, String urlToUserPage, List<GraphicContent> graphicContentsList, List<String> links) {
        this.userName = userName;
        this.userContent = userContent;
        this.date = date;
        this.urlToUserPage = urlToUserPage;
        this.graphicContentsList = graphicContentsList;
        this.links = links;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserContent() {
        return userContent;
    }

    public void setUserContent(String userContent) {
        this.userContent = userContent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrlToUserPage() {
        return urlToUserPage;
    }

    public void setUrlToUserPage(String urlToUserPage) {
        this.urlToUserPage = urlToUserPage;
    }

    public List<GraphicContent> getGraphicContentsList() {
        return graphicContentsList;
    }

    public void setGraphicContentsList(List<GraphicContent> graphicContentsList) {
        this.graphicContentsList = graphicContentsList;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "\n#######################\n =======>SocialNetwork{" + "\n userName=" + userName + ", \n userContent=" + userContent + ", \n date=" + date + ", \n urlToUserPage=" + urlToUserPage + ", \n graphicContentsList=" + graphicContentsList + ", \n\n links=" + links + '}';
    }
}
