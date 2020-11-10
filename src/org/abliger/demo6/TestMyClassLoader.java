package org.abliger.demo6;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author abliger
 * @date 2020/11/10
 * @description
 *  使用继承UrlClassLoader的方式自定义加载器
 */

public class TestMyClassLoader {
    public static void main(String[] args)  {
        //不同的classLoader对象加载的class文件，在内存中不是同一个类
        try {
            URL[] urls= new URL[1];
            urls[0]=new URL("file:///D:/A-program/idea/program/test/classLoader/classLoader/src/");
            final UseUrlClassLoader useUrlClassLoader = new UseUrlClassLoader(urls, "org.abliger.demo6.Code");
            final UseUrlClassLoader useUrlClassLoader2 = new UseUrlClassLoader(urls, "org.abliger.demo6.Code");
            final Class clazz = useUrlClassLoader.getClazz();
            final Class clazz2= useUrlClassLoader2.getClazz();
            System.out.println(clazz.getClassLoader());
            System.out.println(clazz2.getClassLoader());
            final Object o = clazz.newInstance();
            final Object o2 = clazz2.newInstance();
            final Method code = clazz.getMethod("code");
            final Method code2 = clazz2.getMethod("code");
            code.invoke(o);
            code2.invoke(o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
