package com.yao.common.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.*;

/**
 * @author ","妖妖
 * @date : 16:50 2020/9/17
 */
public class CommonUtil {


    public static String httpsGet(String requestUrl, List<BasicHeader> headers) {
        try {
            HttpClient client = HttpClients.createDefault();
            HttpGet get = new HttpGet(requestUrl);
            get.setConfig(RequestConfig.custom().setConnectionRequestTimeout(5000).setSocketTimeout(5000).setConnectTimeout(10000).build());
            for (BasicHeader header : headers) {
                get.setHeader(header);
            }
            HttpResponse response = client.execute(get);
//            for (Header header : response.getAllHeaders()) {
//                System.out.println(header.getName()+" : "+header.getValue());
//            }
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);
            HttpEntity resEntity = response.getEntity();
            String res = EntityUtils.toString(resEntity);
            EntityUtils.consume(resEntity);
//            Log4jUtil.info(HttpProductRelease.class,"上传产品返回报文："+res);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String httpsPostFrom(String requestUrl, List<BasicHeader> headers, Map<String, Object> params) {
        try {
            HttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(requestUrl);
            post.setConfig(RequestConfig.custom().setConnectionRequestTimeout(5000).setSocketTimeout(5000).setConnectTimeout(10000).build());
            if (headers != null)
                for (BasicHeader header : headers) {
                    post.addHeader(header);
                }
            if (params != null) {
                List<NameValuePair> value = new LinkedList<>();
                for (Map.Entry entry : params.entrySet()) {
                    if (entry.getValue() instanceof String[]) {
                        for (String v : (String[]) entry.getValue())
                            value.add(new BasicNameValuePair(entry.getKey().toString(), v));
                    } else {
                        value.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
                    }
                }
                post.setEntity(new UrlEncodedFormEntity(value));
            }
            HttpResponse response = client.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("code : " + statusCode);
            HttpEntity resEntity = response.getEntity();
            String res = EntityUtils.toString(resEntity);
            EntityUtils.consume(resEntity);
            return res;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String httpsPostJson(String requestUrl, List<BasicHeader> headers, JSONObject json) {
        CloseableHttpClient httpClient = null;
        try {
//            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(requestUrl);
//            httpPost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(5000).setSocketTimeout(5000).setConnectTimeout(10000).build());
            if (headers != null)
                for (BasicHeader header : headers) {
                    httpPost.addHeader(header);
                }
            if (json != null) {
                StringEntity requestEntity = new StringEntity(json.toString(), "utf-8");
                requestEntity.setContentEncoding("UTF-8");
                httpPost.setEntity(requestEntity);
            }
            httpPost.setHeader("Content-type", "application/json");
//            String res = httpClient.execute(httpPost,responseHandler);
            HttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("code : " + statusCode);
            HttpEntity resEntity = response.getEntity();
            String res = EntityUtils.toString(resEntity);
            EntityUtils.consume(resEntity);
            return res;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void saveFile(String url, String dirPath,String fileName,List<BasicHeader> headers) {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        httpget.setConfig(RequestConfig.custom().setConnectionRequestTimeout(5000).setSocketTimeout(5000).setConnectTimeout(10000).build());
        for (BasicHeader header : headers) {
            httpget.setHeader(header);
        }
        try {
            HttpResponse resp = httpclient.execute(httpget);
            if (HttpStatus.SC_OK == resp.getStatusLine().getStatusCode()) {
                HttpEntity entity = resp.getEntity();
                InputStream in = entity.getContent();
                saveFile(in, dirPath, fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
    }
    private static void saveFile(InputStream in, String dirPath,String fileName) {
        try {
            File dir = new File(dirPath);
            if (dir == null || !dir.exists()) {
                dir.mkdirs();
            }
            //文件真实路径
            String realPath = dirPath.concat(fileName);
            File file = new File(realPath);
            if (file == null || !file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 全球唯一id
     */
    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        String a = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
        return a;
    }

}
