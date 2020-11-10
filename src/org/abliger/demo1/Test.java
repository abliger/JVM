package org.abliger.demo1;

import org.abliger.MyClassLoader;
import java.lang.reflect.Method;

/**
 * @author abliger
 */

public class Test {

    public static void main(String[] args) throws Exception {
        final MyClassLoader myClassLoader = new MyClassLoader("file:///D:/A-program/idea/program/test/classLoader/classLoader/src/");
        // final MyClassLoader myClassLoader = new MyClassLoader("d://");
        final Class aClass = myClassLoader.findClass("org.abliger.demo1.TestMyClassLoader");
        System.out.println(aClass.getClassLoader());
        final Object o = aClass.newInstance();
        Method method = aClass.getMethod("aaa");
        method.invoke(o);
    }
}
