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
public class JsonRootBean {

    private Feed feed;
    public void setFeed(Feed feed) {
         this.feed = feed;
     }
     public Feed getFeed() {
         return feed;
     }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}