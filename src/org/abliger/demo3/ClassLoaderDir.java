package org.abliger.demo3;

import sun.misc.Launcher;
import sun.misc.URLClassPath;
import sun.plugin2.message.GetAppletMessage;

import java.net.URL;

/**
 * @author abliger
 * @date 2020/11/10
 * @description
 * 获得ClassLoader扫描包
 */

public class ClassLoaderDir {
    public static void main(String[] args) {
        getBootstrapClassLoader();
        System.out.println("=================");
        getExtClassLoaderDir();
        System.out.println("=================");
        getAppClassLoaderDir();
        /*
        我们从打印结果可以得到AppClassLoader可以扫描到BootstrapClassLoader和ExtClassLoader加载的类
         */
    }
    //bootstrapClassLoader
    public static void getBootstrapClassLoader(){
        final String bootstrapClassLoader = System.getProperty("sun.boot.class.path");
        System.out.println("bootstrapClassLoader = " + bootstrapClassLoader);
        System.out.println("加载的路径");
        for (String s : bootstrapClassLoader.split(";")) {
            System.out.println(s);
        }
       /*
       otherExample
           final URLClassPath bootstrapClassPath = Launcher.getBootstrapClassPath();
            final URL[] urLs = bootstrapClassPath.getURLs();
            for (URL urL : urLs) {
                System.out.println(urL.toString());
            }
        */
    }
    //ExtClassLoader
    public static void getExtClassLoaderDir(){
        final String extClassLoader = System.getProperty("java.ext.dirs");
        System.out.println("extClassLoader = " + extClassLoader);
        for (String s : extClassLoader.split(";")) {
            System.out.println(s);
        }
    }
    //AppClassLoader
    public static void getAppClassLoaderDir(){
        final String extClassLoader = System.getProperty("java.class.path");
        System.out.println("extClassLoader = " + extClassLoader);
        for (String s : extClassLoader.split(";")) {
            System.out.println(s);
        }
    }
}
