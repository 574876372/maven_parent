/**
  * Copyright 2018 bejson.com 
  */
package com.sun.parent.common.bean.json;
import java.util.List;

/**
 * Auto-generated: 2018-08-13 17:26:28
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    private int resultCount;
    private List<Results> results;
    public void setResultCount(int resultCount) {
         this.resultCount = resultCount;
     }
     public int getResultCount() {
         return resultCount;
     }

    public void setResults(List<Results> results) {
         this.results = results;
     }
     public List<Results> getResults() {
         return results;
     }

}