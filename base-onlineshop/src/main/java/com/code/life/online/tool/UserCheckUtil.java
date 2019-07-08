package com.code.life.online.tool;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * @author Clay
 * @date 2019/5/8 20:29
 */
public class UserCheckUtil {

    // 每位加权因子
    private static int power[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

    /**
     * 验证Email
     * @param email email地址，格式：zhang@gmail.com，zhang@xxx.com.cn，xxx代表邮件服务商
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkEmail(String email) {
        // String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";//不支持'-'
        String unvalid_eg = ".@";
        if (StringUtils.isEmpty(email) || email.indexOf(unvalid_eg) > 0) {
            return false;
        }
        //old pattern "(\\w-*\\.*)+@(\\w-?)+(\\.\\w{2,})+$";
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        return Pattern.matches(regex, email);
    }


    /**
     /**
     * 验证身份证号码
     * @param idcard 居民身份证号码15位或18位，最后一位可能是数字或字母
     * @return 验证成功返回true，验证失败返回false
     */

    public static boolean checkIdCard(String idcard) {
        // 非18位为假
        if (idcard.length() != 18) {
            return false;
        }
        // 获取前17位
        String idcard17 = idcard.substring(0, 17);
        // 获取第18位
        String idcard18Code = idcard.substring(17, 18);
        String checkCode;
        // 是否都为数字
        if (!UserCheckUtil.isDigital(idcard17)) {
            return false;
        }
        char c[] =  idcard17.toCharArray();

        int bit[] = new int[idcard17.length()];
        bit = UserCheckUtil.convertToInt(c);
        int sum17 = 0;
        sum17 = UserCheckUtil.getPowerSum(bit);
        // 将和值与11取模得到余数进行校验码判断
        checkCode = UserCheckUtil.getCheckCodeBySum(sum17);
        if (null == checkCode) {
            return false;
        }
        // 将身份证的第18位与算出来的校码进行匹配，不相等就为假
        if (!idcard18Code.equalsIgnoreCase(checkCode)) {
            return false;
        }
        return true;
    }

    /**
     * 数字验证
     *
     * @param str
     * @return
     */
    private static boolean isDigital(String str) {
        return str != null && !"".equals(str) && str.matches("^[0-9]*$");
    }



    /**
     * 将字符数组转为整型数组
     *
     * @param c
     * @return
     * @throws NumberFormatException
     */
    private static int[] convertToInt(char[] c) throws NumberFormatException {
        int[] a = new int[c.length];
        int k = 0;
        for (char temp : c) {
            a[k++] = Integer.parseInt(String.valueOf(temp));
        }
        return a;
    }

    /**
     * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
     *
     * @param bit
     * @return
     */
    private static int getPowerSum(int[] bit) {
        int sum = 0;
        if (power.length != bit.length) {
            return sum;
        }
        for (int i = 0; i < bit.length; i++) {
            for (int j = 0; j < power.length; j++) {
                if (i == j) {
                    sum = sum + bit[i] * power[j];
                }
            }
        }
        return sum;
    }


    /**
     * 将和值与11取模得到余数进行校验码判断
     * @param sum17
     * @return 校验位
     */
    private static String getCheckCodeBySum(int sum17) {
        String checkCode = null;
        switch (sum17 % 11) {
            case 10:
                checkCode = "2";
                break;
            case 9:
                checkCode = "3";
                break;
            case 8:
                checkCode = "4";
                break;
            case 7:
                checkCode = "5";
                break;
            case 6:
                checkCode = "6";
                break;
            case 5:
                checkCode = "7";
                break;
            case 4:
                checkCode = "8";
                break;
            case 3:
                checkCode = "9";
                break;
            case 2:
                checkCode = "x";
                break;
            case 1:
                checkCode = "0";
                break;
            case 0:
                checkCode = "1";
                break;
        }
        return checkCode;
    }

    /**
     * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
     * @param mobile 移动、联通、电信运营商的号码段
     *移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
     *、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）
     *联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）
     *电信的号段：133、153、180（未启用）、189
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkMobile(String mobile) {
        // String regex = "(\\+\\d+)?1[3458]\\d{9}$";//15911153422 不能成功校验
        String regexPhone = "^1\\d{10}";//以1开头后跟10个数字
        return Pattern.matches(regexPhone,mobile);
    }

    /**
     * 验证固定电话号码
     * @param phone 电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
     * 国家（地区） 代码 ：标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字，
     *  数字之后是空格分隔的国家（地区）代码。
     * 区号（城市代码）：这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
     * 对不使用地区或城市代码的国家（地区），则省略该组件。
     * 电话号码：这包含从 0 到 9 的一个或多个数字
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkPhone(String phone) {
        String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
        return Pattern.matches(regex, phone);
    }

}
