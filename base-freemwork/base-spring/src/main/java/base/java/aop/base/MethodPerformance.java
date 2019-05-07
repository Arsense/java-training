package base.java.aop.base;


/**
 * @author tangwei
 * @date 2018/12/26 9:50
 */
public class MethodPerformance {

    private long beginTime;
    private long endTime;
    private String method;


    MethodPerformance(String method){
        this.beginTime = System.currentTimeMillis();
        this.method = method;
    }

    public void printPerformance() {
        this.endTime = System.currentTimeMillis();
        long time = beginTime - endTime;
        System.out.println(method + "花费" + time + "毫秒");
    }


}
