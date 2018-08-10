package com.sun.parent.common.utils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpsUtil {


    /**
     * https://www.cnblogs.com/hong-fithing/p/7617855.html
     * @return
     */
    public static CloseableHttpClient createSSLClientDefault(){
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy(){
                //信任所有
                public boolean isTrusted(X509Certificate[] chain,String authType) throws CertificateException{
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }


    public static String sendHttps(String url){
        String content ="";
        try {
            CloseableHttpClient hp = createSSLClientDefault();
            HttpGet hg = new HttpGet(url);
            CloseableHttpResponse response = hp.execute(hg);
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity,"utf-8");
            hp.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return content;
    }
//
//    public static void main(String[] args) throws ClientProtocolException, IOException {
//        CloseableHttpClient hp = createSSLClientDefault();
//        HttpGet hg = new HttpGet("https://rss.itunes.apple.com/api/v1/cn/ios-apps/top-free/all/10/explicit.json");
//        CloseableHttpResponse response = hp.execute(hg);
//        HttpEntity entity = response.getEntity();
//        String content = EntityUtils.toString(entity,"utf-8");
//        System.out.println(content);
//        hp.close();
//    }

}