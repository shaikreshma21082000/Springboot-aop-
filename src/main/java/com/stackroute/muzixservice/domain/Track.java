package com.stackroute.muzixservice.domain;

/*
 * Please note that this class is annotated with @Document annotation
 * @Document identifies a domain object to be persisted to MongoDB.
 *  */


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Track {

    /*
     * This class should have following fields
     * (trackId,trackName,comments,trackListeners,trackUrl,and an object of Artist
     *  Out of these fields, the field
     * trackId should be annotated with @Id. This class should also contain the
     * getters and setters for the fields along with the no-arg , parameterized
     * constructor and toString method.
     */
  @Id
    private String trackId;
    private String trackName,comments,trackListeners,trackUrl;
    private Artist artist;

    public Track() {
    }

    public Track(String trackId, String trackName, String comments, String trackListeners, String trackUrl, Artist artist) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.comments = comments;
        this.trackListeners = trackListeners;
        this.trackUrl = trackUrl;
        this.artist = artist;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTrackListeners() {
        return trackListeners;
    }

    public void setTrackListeners(String trackListeners) {
        this.trackListeners = trackListeners;
    }

    public String getTrackUrl() {
        return trackUrl;
    }

    public void setTrackUrl(String trackUrl) {
        this.trackUrl = trackUrl;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId='" + trackId + '\'' +
                ", trackName='" + trackName + '\'' +
                ", comments='" + comments + '\'' +
                ", trackListeners='" + trackListeners + '\'' +
                ", trackUrl='" + trackUrl + '\'' +
                ", artist=" + artist +
                '}';
    }
}
