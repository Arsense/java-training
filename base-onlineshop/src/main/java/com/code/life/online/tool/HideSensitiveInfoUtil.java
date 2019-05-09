package com.code.life.online.tool;

import org.apache.commons.lang3.StringUtils;

/**
 * @author tangwei
 * @date 2019/5/9 14:11
 */
public class HideSensitiveInfoUtil {
    /**
     * 隐藏用户手机号敏感信息，显前三后四，隐中四
     *
     * @param phone 手机号
     * @return 处理结果
     */
    public static String hideForPhone(String phone) {
        if (StringUtils.isBlank(phone) || phone.length() != 11) {//非法手机号
            return phone;//原样返回
        }
        return phone.substring(0, 3) +  //取前三位
                getStarChar(4) +  //隐藏中间四位
                phone.substring(7);     //取后四位
    }

    /**
     * 隐藏用户身份证号敏感信息，显前四后四，隐中十位，不考虑短身份证号，默认传入18位身份证为合法数据
     *
     * @param idCard 身份证号
     * @return 处理结果
     */
    public static String hideForIdCard(String idCard) {
        if (StringUtils.isEmpty(idCard) || idCard.length() != 18) {//非法身份证号
            return idCard;//原样返回
        }
        return idCard.substring(0, 4) +  //取前四位
                getStarChar(10) +  //隐藏中间十位
                idCard.substring(14);     //取后四位
    }

    /**
     * 直接前面两位显示、后面两位显示，中间十位*
     *
     * @param idCard 证件号码
     * @return 处理结果
     */
    public static String hideForIdCardOther(String idCard) {
        if (StringUtils.isEmpty(idCard)) {//非法证件号码
            return idCard;//原样返回
        }
        return idCard.substring(0, 2) +  //取前四位
                getStarChar(10) +  //隐藏中间十位
                idCard.substring(idCard.length() - 2, idCard.length());     //取后四位
    }

    /**
     * 直接前面两位显示、后面四位显示，中间十位*
     *
     * @param cardNo 会员卡号
     * @return 处理结果
     */
    public static String hideForCardNo(String cardNo) {
        if (StringUtils.isEmpty(cardNo)) {//会员卡号不合法
            return cardNo;//原样返回
        }
        return cardNo.substring(0, 2) +  //取前两位
                getStarChar(10) +  //隐藏中间十位
                cardNo.substring(cardNo.length() - 4, cardNo.length());     //取后四位
    }


    /**
     * 隐藏用户电子邮箱敏感信息<br>
     * 位数>4位，只展示前面2位和后面2位，中间加5颗*，2<=位数<=4，则只显示第1位和最后1位，中间加5颗*，1位，展示成a*****@qq.com。
     *
     * @param email 身份证号
     * @return 处理结果
     */
    public static String hideForEmail(String email) {
        if (StringUtils.isEmpty(email)) {//非法电子邮箱
            return email;//原样返回
        }
        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || atIndex >= email.length() - 1) {//邮箱格式不合法
            return email;
        }
        String prefix = email.substring(0, atIndex);//前缀
        String postfix = email.substring(atIndex);  //后缀
        int length = prefix.length();//前棳长度
        if (length == 1) {         //前缀位数等于1
            return prefix +                //取前一位
                    getStarChar(5) +        //中间加5颗星
                    postfix;                //加后缀
        }
        if (length <= 4 && length >= 2) {  //二位和四位之间的
            return prefix.substring(0, 1) +                 //取前一位
                    getStarChar(5) +          //中间加5颗星
                    prefix.substring(length - 1) + //取后一位
                    postfix;                  //加后缀

        }
        if (length > 4) {             //前缀大于四位
            return prefix.substring(0, 2) +   //取前两位
                    getStarChar(5) +          //中间加5颗星
                    prefix.substring(length - 2) +    //取后两位
                    postfix;                  //加后缀
        }
        return email;//其它情况返回原值
    }

    /**
     * 加密用户姓名
     * @param name 用户姓名，形如“张三”
     * @return 加密后的用户姓名“张***”
     */
    public static String hideForName(String name) {
        if (StringUtils.isBlank(name)) return name;//空值返回
        return name.substring(0, 1) + getStarChar(3);
    }

    /**
     * 加密地址
     * @param address 地址，形如“北辰世纪中心A座6层”
     * @return 加密后的地址，形如“北辰********6层”
     */
    public static String hideForAddress(String address) {
        if (StringUtils.isBlank(address)) return address;//空值返回
        if(address.length()<4) return address;
        return address.substring(0, 2) +  //取前2位
                getStarChar(8) +  //隐藏中间十位
                address.substring(address.length() - 2, address.length());
    }

    /**
     * 加密纳税人识别号
     * @param num 纳税人识别号，形如“91310107MA1G07E95K”
     * @return 加密后的纳税人识别号，形如“9131****E95K”
     */
    public static String hideForIdentificationNumber(String num) {
        if (StringUtils.isBlank(num)) return num;//空值返回
        if(num.length()<8) return num;
        return num.substring(0, 4) +  //取前2位
                getStarChar(8) +  //隐藏中间10位
                num.substring(num.length() - 4, num.length());
    }

    /**
     * 加密生日信息
     * @param birth 日期字符串，形如“2010-02-18”
     * @return 加密后的生日，形如“2010*****”
     */
    public static String hideForBirth(String birth) {
        if (StringUtils.isBlank(birth)) return birth;//空值返回
        if(birth.length()<4) return birth;
        return birth.substring(0, 4) + getStarChar(5);
    }

    /**
     * 加密公司名称信息、法人姓名
     * @param company 公司名称信息、法人姓名字符串，形如“上海盛岚贸易有限公司”
     * @return 加密后的生日，形如“上海盛岚*****”
     */
    public static String hideForCompanyName(String company) {
        if (StringUtils.isBlank(company)) return company;//空值返回
        if(company.length()<4) return company;
        return company.substring(0, 4) + getStarChar(5);
    }

    /**
     * 获得一定数量的星号
     *
     * @param num 星号的数量
     * @return 结果
     */
    public static String getStarChar(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            stringBuilder.append("*");
        }
        return stringBuilder.toString();
    }

    /**
     * 测试使用
     */
    /*public static void main(String[] args) {
        System.out.println("手机号");
        System.out.println(hideForPhone("18588888888"));
        System.out.println(hideForPhone("181118"));
        System.out.println(hideForPhone(""));
        System.out.println(hideForPhone(null));

        System.out.println("身份证号");
        System.out.println(hideForIdCard("185888888888888890"));
        System.out.println(hideForIdCard("1811198988"));
        System.out.println(hideForIdCard(""));
        System.out.println(hideForIdCard(null));

        System.out.println("电子邮箱");
        System.out.println(hideForEmail(null));
        System.out.println(hideForIdCardOther("fggh567457657"));
        System.out.println(hideForName(""));
        System.out.println(hideForName(null));
        System.out.println(hideForName("张"));
        System.out.println(hideForName("张三"));
        System.out.println(hideForName("张三里四"));

    }*/
}
