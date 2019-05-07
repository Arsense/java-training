package base.java.aop.base;

/**
 * @author tangwei
 * @date 2018/12/26 9:47
 */
public class PerformanceMonitor {
    //通过一个ThreadLocal保存调用线程相关的性能监视信息

    private static ThreadLocal<MethodPerformance> methodPerformanceRecord = new ThreadLocal<MethodPerformance>();


    //监控一
    public static void begin(String method) {
        System.out.println("begin monitor");
        MethodPerformance mp = new MethodPerformance(method);
        methodPerformanceRecord.set(mp);
    }


    //结束监控
    public static void end() {
        System.out.println("end monitor");
        MethodPerformance mp = methodPerformanceRecord.get();

        mp.printPerformance();
    }

}
