package org.abliger.demo2;

/**
 * @author abliger
 * @date 2020/11/10
 * @description 测试不容classloader加载文件
 */

public class TestTwoClassLoader {
    /**
     * MyClassLoader2不能重新加载已加载的class文件
     */
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        final MyClassLoader myClassLoader1 = new MyClassLoader("file:///D:/A-program/idea/program/test/classLoader/classLoader/src/");
        final MyClassLoader myClassLoader2 = new MyClassLoader("file:///D:/A-program/idea/program/test/classLoader/classLoader/src/");
        final Class clazz1 = myClassLoader1.findClass("org.abliger.demo2.demo");
        final Class clazz2 = myClassLoader2.findClass("org.abliger.demo2.demo");
        final Class clazz3 = ClassLoader.getSystemClassLoader().loadClass("org.abliger.demo2.demo");
        final Object o1 = clazz1.newInstance();
        final Object o2 = clazz2.newInstance();
        final Object o3 = clazz3.newInstance();
        System.out.println(o1.getClass().getClassLoader());//org.abliger.demo2.MyClassLoader@4554617c
        System.out.println(o1==o3);//false
        System.out.println(o1==o2);//false
    }
}
