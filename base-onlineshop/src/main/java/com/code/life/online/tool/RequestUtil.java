package com.code.life.online.tool;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author Clay
 * @date 2019/5/8 13:51
 */
public class RequestUtil {
    private static Logger logger = LoggerFactory.getLogger(RequestUtil.class);

    /**
     * 取请求IP,如果有代理，返回后面一个真实IP
     *
     * @param request
     * @return
     */
    public static final String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) { //"***.***.***.***".length() = 15
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }



    /**
     * 获取请求IP
     * @param request
     * @return
     */
    public static String getSingleIpAddr(HttpServletRequest request) {
        String ip = "";
        try {
            ip = getIpAddr(request);
            //存如下单用户IP地址
            if (ip != null && ip.indexOf(",") > 0) {
                logger.info("取到客户多个ip1====================" + ip);
                String[] arr = ip.split(",");
                ip = arr[arr.length - 1].trim();//有多个ip时取最后一个ip
                logger.info("取到客户多个ip2====================" + ip);
            }
        } catch (Exception e) {
            logger.error("获取ip地址异常",e);
        }
        return ip;
    }

    /**
     * 取请求IP
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
