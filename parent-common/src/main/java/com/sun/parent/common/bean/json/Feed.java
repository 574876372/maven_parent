/**
  * Copyright 2018 bejson.com 
  */
package com.sun.parent.common.bean.json;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
import java.util.Date;

/**
 * Auto-generated: 2018-08-10 17:12:9
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Feed {

    private String title;
    private String id;
    private Author author;
    private List<Links> links;
    private String copyright;
    private String country;
    private String icon;
    private Date updated;
    private List<Results> results;
    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setAuthor(Author author) {
         this.author = author;
     }
     public Author getAuthor() {
         return author;
     }

    public void setLinks(List<Links> links) {
         this.links = links;
     }
     public List<Links> getLinks() {
         return links;
     }

    public void setCopyright(String copyright) {
         this.copyright = copyright;
     }
     public String getCopyright() {
         return copyright;
     }

    public void setCountry(String country) {
         this.country = country;
     }
     public String getCountry() {
         return country;
     }

    public void setIcon(String icon) {
         this.icon = icon;
     }
     public String getIcon() {
         return icon;
     }

    public void setUpdated(Date updated) {
         this.updated = updated;
     }
     public Date getUpdated() {
         return updated;
     }

    public void setResults(List<Results> results) {
         this.results = results;
     }
     public List<Results> getResults() {
         return results;
     }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}