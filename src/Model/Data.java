package Model;

/**
 *
 * @author Dilmurod Tashpulatov
 */
public class Data implements java.io.Serializable{
    private String url;
    private String source;
    private String claim;
    private String claim_url;
    private String label;
    private String author;
    private String date;

    public Data() {
    }

    public Data(String url, String source, String claim, String claim_url, String label, String author, String date) {
        this.url = url;
        this.source = source;
        this.claim = claim;
        this.claim_url = claim_url;
        this.label = label;
        this.author = author;
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public String getClaim_url() {
        return claim_url;
    }

    public void setClaim_url(String claim_url) {
        this.claim_url = claim_url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Data{" + "url=" + url + ", source=" + source + ", claim=" + claim + ", claim_url=" + claim_url + ", label=" + label + ", author=" + author + ", date=" + date + '}';
    }
}
