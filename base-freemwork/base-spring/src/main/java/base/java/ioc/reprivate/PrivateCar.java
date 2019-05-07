package base.java.ioc.reprivate;

/**
 * @author tangwei
 * @date 2018/12/25 11:07
 */
public class PrivateCar {

    private String color;


    protected void drive() {
        System.out.println("drive private car!the color is:" + color);
    }
}
