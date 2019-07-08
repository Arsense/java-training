package com.base.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * @author Clay
 * @date 2019/1/16 9:51
 */
public class Java8Tester {
    public static void main(String[] args) {

        List<String> names1 = new ArrayList<String>();
        names1.add("Mahesh ");
        names1.add("Suresh ");
        names1.add("Ramesh ");
        names1.add("Naresh ");
        names1.add("Kalpesh ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Mahesh ");
        names2.add("Suresh ");
        names2.add("Ramesh ");
        names2.add("Naresh ");
        names2.add("Kalpesh ");

        Java8Tester tester = new Java8Tester();
        System.out.println("Sort using Java 7 syntax: ");

        tester.sortUsingJava7(names1);
        System.out.println(names1);
        System.out.println("Sort using Java 8 syntax: ");
        tester.sortUsingJava8(names2);
        System.out.println(names2);

        List<String> names = new ArrayList();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");
        for (String name: names) {
            System.out.println(name);
        }
    }


    public void sortUsingJava7(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return  o1.compareTo(o2);
            }
        });
    }



    private void sortUsingJava8(List<String> names) {
        names.sort(String::compareTo);
    }
}
