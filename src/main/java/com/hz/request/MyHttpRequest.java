package com.hz.request;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Tom on 2017/7/4.
 */
public class MyHttpRequest {

    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static String get(String url, List<NameValuePair> params) {
        String body = null;
        try {
            // Get����
            HttpGet httpget = new HttpGet(url);
            // ���ò���
            if(params!=null) {
                String str = EntityUtils.toString(new UrlEncodedFormEntity(params));
                httpget.setURI(new URI(httpget.getURI().toString() + "?" + str));
            }
            // ��������
            HttpResponse httpresponse = httpClient.execute(httpget);
            // ��ȡ��������
            HttpEntity entity = httpresponse.getEntity();
            body = EntityUtils.toString(entity);
            if (entity != null) {
                EntityUtils.consume(entity);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return body;
    }

    public static void main(String[] args) {
        System.out.println(get("http://woshiwangmo.com/wangmo/home/index.php?act=index&op=task",null));
    }
}
