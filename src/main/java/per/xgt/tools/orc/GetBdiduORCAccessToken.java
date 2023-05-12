package per.xgt.tools.orc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: Valen
 * @createTime: 2023-05-06日 16:48:06
 * @version: 1.0
 * @Description:
 */
public class GetBdiduORCAccessToken {

    /**
     *
     * @param url 请求地址
     * @param param 请求参数
     * @return
     */
    public static String sendPost(String url,String param){
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("Accept","application/json");
            conn.setRequestProperty("Content-Type","application/json");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null){
                result += line;
            }
        } catch (Exception e){
            System.out.println("发送POST请求出现异常 : " + e);
            e.printStackTrace();
        } finally {
            // 关闭输入输出流
            try {
                if (null != out){
                    out.close();
                }
                if (null != in){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
