package com.hzsun.demotest.commons.utils;

import com.hzsun.demotest.commons.exceptions.ServiceErrorEnum;
import com.hzsun.demotest.commons.exceptions.ServiceException;

import javax.net.ssl.*;
import javax.security.cert.X509Certificate;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.util.Map;
import java.util.Map.Entry;

/**
* @Description:  
 * @Author: dingjl  
* @Date: 2018年5月30日  
**/
public class HttpUtil {
    private final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    private static void trustAllHosts() {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
            }

            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
                    throws CertificateException {
                // TODO
            }
            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
                    throws CertificateException {
                // TODO
            }
        } };
        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String doPost( String url,Map<String, String> params) {
        String result = "";
        PrintWriter out = null;
        BufferedReader in = null;
        HttpURLConnection conn;
        try {
            trustAllHosts();
            URL realUrl = new URL(url);
            // 通过请求地址判断请求类型(http或者是https)
            if (realUrl.getProtocol().toLowerCase().equals("https")) {
                HttpsURLConnection https = (HttpsURLConnection) realUrl.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                conn = https;
            } else {
                conn = (HttpURLConnection) realUrl.openConnection();
            }
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);//可写
            conn.setDoInput(true); //可读
           // 设置不用缓存  
           conn.setUseCaches(false);  
           // 设置传递方式  
           conn.setRequestMethod("POST");  
           // 设置维持长连接  
            conn.setRequestProperty("Connection", "Keep-Alive");  
           // 设置文件字符集:  
           conn.setRequestProperty("Charset", "UTF-8"); 
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            String paramer= getPostParamer(params).toString();
            // 发送请求参数
            out.print(paramer);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) { 
            throw new ServiceException(ServiceErrorEnum.E_Connection_HttpRequestException,e);
        } finally {// 使用finally块来关闭输出流、输入流
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
       
        return result;
    }
    
    public static String doPost( String url,String json) {
        String result = "";
        PrintWriter out = null;
        BufferedReader in = null;
        HttpURLConnection conn;
        try {
            trustAllHosts();
            URL realUrl = new URL(url);
            // 通过请求地址判断请求类型(http或者是https)
            if (realUrl.getProtocol().toLowerCase().equals("https")) {
                HttpsURLConnection https = (HttpsURLConnection) realUrl.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                conn = https;
            } else {
                conn = (HttpURLConnection) realUrl.openConnection();
            }
            // 设置通用的请求属性
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            // 设置允许输入  
            conn.setDoInput(true);  
           // 设置不用缓存  
           conn.setUseCaches(false);  
           // 设置传递方式  
           conn.setRequestMethod("POST");  
           // 设置维持长连接  
            conn.setRequestProperty("Connection", "Keep-Alive");  
           // 设置文件字符集:  
           conn.setRequestProperty("Charset", "UTF-8");  
           // 转换为字节数组  
           byte[] data = (json.toString()).getBytes();  
          // 设置文件长度  
           conn.setRequestProperty("Content-Length", String.valueOf(data.length));  
          // 设置文件类型:
          conn.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(json);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) { 
            throw new ServiceException(ServiceErrorEnum.E_Connection_HttpRequestException,e);
        } finally {// 使用finally块来关闭输出流、输入流
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
       
        return result;
    }
    public static String doPost( String url,String json, String contentType) {
        String result = "";
        PrintWriter out = null;
        BufferedReader in = null;
        HttpURLConnection conn;
        try {
            trustAllHosts();
            URL realUrl = new URL(url);
            // 通过请求地址判断请求类型(http或者是https)
            if (realUrl.getProtocol().toLowerCase().equals("https")) {
                HttpsURLConnection https = (HttpsURLConnection) realUrl.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                conn = https;
            } else {
                conn = (HttpURLConnection) realUrl.openConnection();
            }
            // 设置通用的请求属性
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            // 设置允许输入
            conn.setDoInput(true);
            // 设置不用缓存
            conn.setUseCaches(false);
            // 设置传递方式
            conn.setRequestMethod("POST");
            // 设置维持长连接
            conn.setRequestProperty("Connection", "Keep-Alive");
            // 设置文件字符集:
            conn.setRequestProperty("Charset", "UTF-8");
            // 转换为字节数组
            byte[] data = (json.toString()).getBytes();
            // 设置文件长度
            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
            // 设置文件类型:
            if (null == contentType || "".equals(contentType)){
                conn.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            }else{
                conn.setRequestProperty("Content-Type", contentType);
            }
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(json);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            throw new ServiceException(ServiceErrorEnum.E_Connection_HttpRequestException,e);
        } finally {// 使用finally块来关闭输出流、输入流
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }

    
   public static String doGet( String url,Map<String, String> params){
       InputStream inputStream = null;
       InputStreamReader inputStreamReader = null;
       BufferedReader reader = null;
       StringBuffer resultBuffer = new StringBuffer();
       
       try {
           URL localURL=null;
           if(CollectionUtil.isEmpty(params)){
               localURL = new URL(url);
           }else{
               localURL = new URL(url+"?"+getParamer(params));
           }
   
       URLConnection connection = localURL.openConnection();
       HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
       
       httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
       httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
       
       
       String tempLine = null;
       
       if (httpURLConnection.getResponseCode() >= 300) {
           throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
       }
       
      
           inputStream = httpURLConnection.getInputStream();
           inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
           reader = new BufferedReader(inputStreamReader);
           
           while ((tempLine = reader.readLine()) != null) {
               resultBuffer.append(tempLine);
           }
           
       } catch (Exception e) { 
           throw new ServiceException(ServiceErrorEnum.E_Connection_HttpRequestException,e);
       }  finally {
           try {
               if (reader != null) {
                   reader.close();
               }
               
               if (inputStreamReader != null) {
                   inputStreamReader.close();
               }
               
               if (inputStream != null) {
                   inputStream.close();
               }
           } catch (IOException ex) {
               ex.printStackTrace();
           }
       }
       
       return resultBuffer.toString();
   } 

public static StringBuffer getParamer(Map<String, String> params) throws UnsupportedEncodingException{
        
        StringBuffer sb = new StringBuffer();    
        if (params != null) {    
            for (Entry<String, String> e : params.entrySet()) { 
                
                sb.append(e.getKey());    
                sb.append("=");  
                if(CollectionUtil.isNotEmpty(e.getValue())){
                    sb.append(URLEncoder.encode(e.getValue(), "utf-8"));
                }else{
                    sb.append(e.getValue());
                }
               
                sb.append("&");    
            }    
            //sb.substring(0, sb.length() - 1);  
            sb=sb.deleteCharAt(sb.length() - 1); 
        } 
        return sb;
    }
 
 private static StringBuffer getPostParamer(Map<String, String> params) throws UnsupportedEncodingException{
     
     StringBuffer sb = new StringBuffer();    
     if (params != null && !params.isEmpty()) {    
         for (Entry<String, String> e : params.entrySet()) { 
             
             sb.append(e.getKey());    
             sb.append("=");  
             if(CollectionUtil.isNotEmpty(e.getValue())){
                 sb.append(URLEncoder.encode(e.getValue(), "utf-8"));
             }else{
                 sb.append(e.getValue());
             }
            
             sb.append("&");    
         }    
         //sb.substring(0, sb.length() - 1);  
         sb=sb.deleteCharAt(sb.length() - 1); 
     } 
     return sb;
 }
 
 
 
 /**
  * @param url 请求地址
  * @param map 请求的参数
  * @param filePath 文件路径
  * @param fileField 文件域
  * @param charset 字符集
  * @return
  */
 public static String doPostSubmitBody(String url, Map<String, String> map,
         String filePath,String fileField, String charset) {
     // 设置三个常用字符串常量：换行、前缀、分界线（NEWLINE、PREFIX、BOUNDARY）；
     final String NEWLINE = "\r\n"; // 换行，或者说是回车
     final String PREFIX = "--"; // 固定的前缀
     final String BOUNDARY = "#"; // 分界线，就是上面提到的boundary，可以是任意字符串，建议写长一点，这里简单的写了一个#
     HttpURLConnection httpConn = null;
     BufferedInputStream bis = null;
     DataOutputStream dos = null;
     ByteArrayOutputStream baos = new ByteArrayOutputStream();
     try {
         // 实例化URL对象。调用URL有参构造方法，参数是一个url地址；
         URL urlObj = new URL(url);
         // 调用URL对象的openConnection()方法，创建HttpURLConnection对象；
         httpConn = (HttpURLConnection) urlObj.openConnection();
         // 调用HttpURLConnection对象setDoOutput(true)、setDoInput(true)、setRequestMethod("POST")；
         httpConn.setDoInput(true);
         httpConn.setDoOutput(true);
         httpConn.setRequestMethod("POST");
         // 设置Http请求头信息；（Accept、Connection、Accept-Encoding、Cache-Control、Content-Type、User-Agent），不重要的就不解释了，直接参考抓包的结果设置即可
         httpConn.setUseCaches(false);
         httpConn.setRequestProperty("Connection", "Keep-Alive");
         httpConn.setRequestProperty("Accept", "*/*");
         httpConn.setRequestProperty("Accept-Encoding", "gzip, deflate");
         httpConn.setRequestProperty("Cache-Control", "no-cache");
         // 这个比较重要，按照上面分析的拼装出Content-Type头的内容
         httpConn.setRequestProperty("Content-Type",
                 "multipart/form-data; boundary=" + BOUNDARY);
         // 这个参数可以参考浏览器中抓出来的内容写，用chrome或者Fiddler抓吧看看就行
         httpConn.setRequestProperty(
                 "User-Agent",
                 "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30)");
         // 调用HttpURLConnection对象的connect()方法，建立与服务器的真实连接；
         httpConn.connect();

         // 调用HttpURLConnection对象的getOutputStream()方法构建输出流对象；
         dos = new DataOutputStream(httpConn.getOutputStream());
         // 获取表单中上传控件之外的控件数据，写入到输出流对象（根据上面分析的抓包的内容格式拼凑字符串）；
         if (map != null && !map.isEmpty()) { // 这时请求中的普通参数，键值对类型的，相当于上面分析的请求中的username，可能有多个
             for (Map.Entry<String, String> entry : map.entrySet()) {
                 String key = entry.getKey(); // 键，相当于上面分析的请求中的username
                 String value = map.get(key); // 值，相当于上面分析的请求中的sdafdsa
                 dos.writeBytes(PREFIX + BOUNDARY + NEWLINE); // 像请求体中写分割线，就是前缀+分界线+换行
                 dos.writeBytes("Content-Disposition: form-data; "
                         + "name=\"" + key + "\"" + NEWLINE); // 拼接参数名，格式就是Content-Disposition: form-data; name="key" 其中key就是当前循环的键值对的键，别忘了最后的换行 
                 dos.writeBytes(NEWLINE); // 空行，一定不能少，键和值之间有一个固定的空行
                 dos.writeBytes(URLEncoder.encode(value.toString(), charset)); // 将值写入
                 // 或者写成：dos.write(value.toString().getBytes(charset));
                 dos.writeBytes(NEWLINE); // 换行
             } // 所有循环完毕，就把所有的键值对都写入了
         }

         // 获取表单中上传附件的数据，写入到输出流对象（根据上面分析的抓包的内容格式拼凑字符串）；
         if (CollectionUtil.isNotEmpty(filePath) ) {
             dos.writeBytes(PREFIX + BOUNDARY + NEWLINE);// 像请求体中写分割线，就是前缀+分界线+换行
             String fileName = filePath.substring(filePath
                     .lastIndexOf(File.separatorChar) + 1); // 通过文件路径截取出来文件的名称，也可以作文参数直接传过来
             // 格式是:Content-Disposition: form-data; name="请求参数名"; filename="文件名"
             // 我这里吧请求的参数名写成了uploadFile，是死的，实际应用要根据自己的情况修改
             // 不要忘了换行
             
             dos.writeBytes("Content-Disposition: form-data; " + "name=\""
                     + fileField + "\"" + "; filename=\"" + fileName
                     + "\"" + NEWLINE);
             // 换行，重要！！不要忘了
             dos.writeBytes(NEWLINE);
             File file=new File(filePath);
             InputStream in=new FileInputStream(file);
             byte[] bts=new byte[(int)file.length()];
             in.read(bts);
             in.close();
             dos.write(bts); // 上传文件的内容
             dos.writeBytes(NEWLINE); // 最后换行
         }
         dos.writeBytes(PREFIX + BOUNDARY + PREFIX + NEWLINE); // 最后的分割线，与前面的有点不一样是前缀+分界线+前缀+换行，最后多了一个前缀
         dos.flush();

         // 调用HttpURLConnection对象的getInputStream()方法构建输入流对象；
         byte[] buffer = new byte[8 * 1024];
         int c = 0;
         // 调用HttpURLConnection对象的getResponseCode()获取客户端与服务器端的连接状态码。如果是200，则执行以下操作，否则返回null；
         if (httpConn.getResponseCode() == 200) {
             bis = new BufferedInputStream(httpConn.getInputStream());
             while ((c = bis.read(buffer)) != -1) {
                 baos.write(buffer, 0, c);
                 baos.flush();
             }
         }
         // 将输入流转成字节数组，返回给客户端。
         return new String(baos.toByteArray(), charset);
     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         try {
             if (dos != null)
                 dos.close();
             if (bis != null)
                 bis.close();
             if (baos != null)
                 baos.close();
             httpConn.disconnect();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     return null;
 }
    
  
}
  
    