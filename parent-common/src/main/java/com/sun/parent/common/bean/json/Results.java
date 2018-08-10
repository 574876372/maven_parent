/**
  * Copyright 2018 bejson.com 
  */
package com.sun.parent.common.bean.json;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2018-08-10 17:12:9
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Results {

    private String artistName;
    private String id;
    private Date releaseDate;
    private String name;
    private String kind;
    private String copyright;
    private String artistId;
    private String artistUrl;
    private String artworkUrl100;
    private List<Genres> genres;
    private String url;
    public void setArtistName(String artistName) {
         this.artistName = artistName;
     }
     public String getArtistName() {
         return artistName;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setReleaseDate(Date releaseDate) {
         this.releaseDate = releaseDate;
     }
     public Date getReleaseDate() {
         return releaseDate;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setKind(String kind) {
         this.kind = kind;
     }
     public String getKind() {
         return kind;
     }

    public void setCopyright(String copyright) {
         this.copyright = copyright;
     }
     public String getCopyright() {
         return copyright;
     }

    public void setArtistId(String artistId) {
         this.artistId = artistId;
     }
     public String getArtistId() {
         return artistId;
     }

    public void setArtistUrl(String artistUrl) {
         this.artistUrl = artistUrl;
     }
     public String getArtistUrl() {
         return artistUrl;
     }

    public void setArtworkUrl100(String artworkUrl100) {
         this.artworkUrl100 = artworkUrl100;
     }
     public String getArtworkUrl100() {
         return artworkUrl100;
     }

    public void setGenres(List<Genres> genres) {
         this.genres = genres;
     }
     public List<Genres> getGenres() {
         return genres;
     }

    public void setUrl(String url) {
         this.url = url;
     }
     public String getUrl() {
         return url;
     }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}