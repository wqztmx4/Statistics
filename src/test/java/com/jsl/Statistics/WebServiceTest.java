package com.jsl.Statistics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class WebServiceTest {
	
	public static String afterWorkDay(String startDate , int distance) {
		return sendGet("afterWorkDay/"+startDate+"/"+distance);
	}
	
	public static String beforeWorkDay(String startDate , int distance) {
		return sendGet("beforeWorkDay/"+startDate+"/"+distance);
	}
	
	public static String calcWorkDay(String startDate , String endDate) {
		return sendGet("calcWorkDay/"+startDate+"/"+endDate);
	}
    
	
	/**
     * 向指定URL发送GET方法的请求
     *
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String param) {
    	String url = "http://129.211.22.18:8080/Statistics";
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "/" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            //Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            //for (String key : map.keySet()) {
            //   System.out.println(key + "--->" + map.get(key));
            //}
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
		//输出服务器返回的对象
    	System.out.println(beforeWorkDay("2019-8-24", 3));
		//这是将返回对象转为json对象，使用的是阿里的fastjson包
    	JSONObject data = JSONObject.parseObject(afterWorkDay("2019-8-24", 3));
		//转换成json对象后，即可获取对应的属性。
    	System.out.println(data.get("workdate").toString());
		System.out.println(data.get("week_day").toString());
		System.out.println(data.get("isHoliday").toString());
	}

}
