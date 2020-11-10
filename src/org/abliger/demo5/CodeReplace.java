package org.abliger.demo5;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * @author abliger
 * @date 2020/11/10
 * @description
 *  实现代码热替换
 */

public class CodeReplace {
    public static void main(String[] args)  {
        try {
            while (true){
                final MyClassLoader myClassLoader = new MyClassLoader("file:///D:/A-program/idea/program/test/classLoader/classLoader/src/");
                final Class clazz = myClassLoader.findClass("org.abliger.demo5.NeedReplace");
                final Object o = clazz.newInstance();
                final Method hot = clazz.getMethod("hot");
                final Object invoke = hot.invoke(o);
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
