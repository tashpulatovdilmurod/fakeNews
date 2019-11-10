/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.*;

/**
 *
 * @author Dilmurod Tashpulatov
 */
public class GeneralParcelModel implements java.io.Serializable{
    private String title;
    private List<String> paragraphs = new ArrayList<>();
    private List<String> headers = new ArrayList<>();
    private List<String> links = new ArrayList<>();
    private List<String> images = new ArrayList<>();
    private List<String> videos = new ArrayList<>();
    
    
    private String notes;
    private String bvalue;
    private String kvalue;

    public GeneralParcelModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBvalue() {
        return bvalue;
    }

    public void setBvalue(String bvalue) {
        this.bvalue = bvalue;
    }

    public String getKvalue() {
        return kvalue;
    }

    public void setKvalue(String kvalue) {
        this.kvalue = kvalue;
    }
}
