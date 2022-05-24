package com.stackroute.muzixservice.domain;

import org.springframework.data.annotation.Id;

//@Data
public class Artist {
    /*
     * This class should have following fields
     * (artistId,artistName,url,and an object of Image
     *  Out of these fields, the field
     * artistId should be annotated with @Id. This class should also contain the
     * getters and setters for the fields along with the no-arg , parameterized
     * constructor and toString method.
     */
    @Id
    private int artistId;
    private String artistName,url;
    private Image image;

    public Artist() {
    }


    public Artist(int artistId, String artistName, String url, Image image) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.url = url;
        this.image = image;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", artistName='" + artistName + '\'' +
                ", url='" + url + '\'' +
                ", image=" + image +
                '}';
    }

}
