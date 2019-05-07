package base.java.ioc.loader;

/**
 * @author tangwei
 * @date 2018/12/25 11:02
 */
public class LoaderParent {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("classLoader is" + classLoader);
        System.out.println("classLoader is" + classLoader.getParent());
        //ClassLoader 是根加载器获取不到 句柄的
        System.out.println("classLoader is" + classLoader.getParent().getParent());

    }
}
