/**
  * Copyright 2018 bejson.com 
  */
package com.sun.parent.common.bean.json;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Auto-generated: 2018-08-10 17:12:9
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Genres {

    private String genreId;
    private String name;
    private String url;
    public void setGenreId(String genreId) {
         this.genreId = genreId;
     }
     public String getGenreId() {
         return genreId;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
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