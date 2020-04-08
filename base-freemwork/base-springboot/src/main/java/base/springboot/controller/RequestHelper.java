package base.springboot.controller;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author clay
 * @date 2020/4/8 0:19
 */
public class RequestHelper {
    /**
     * 站点
     */
    private static String config1;


    /**
     * 对应site 配置信息
     *
     */
    private static String config2;

    @Value("${app.config1}")
    public void setRegion(String config1) {
        RequestHelper.config1= config1;
    }

    @Value("${app.config2}")
    public void setTenantId(String config2) {
        RequestHelper.config2= config2;
    }

    public static String getConfig1() {
        return config1;
    }

    public static String getConfig2() {
        return config2;
    }


}
