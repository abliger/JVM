package org.abliger.demo4;

/**
 * @author abliger
 * @date 2020/11/10
 * @description
 */

public class ArrayClassLoader {
    public static void main(String[] args) {
        String[] str=new String[10];
        final ClassLoader bootstrapClassLoader = str.getClass().getClassLoader();
        System.out.println(bootstrapClassLoader);//null 说明有BootstrapClassLoader加载
        final ArrayClassLoader arrayClassLoader = new ArrayClassLoader();
        final ClassLoader appClassLoader = arrayClassLoader.getClass().getClassLoader();
        System.out.println(appClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2
        int[] ints=new int[10];
        final ClassLoader classLoader = ints.getClass().getClassLoader();
        System.out.println(classLoader);//null
        /*
        注意此处的classLoader的值为null，不是说此处int类型是由bootstrapClassLoader加载的，
        而是基础数据类型是JVM预先定义的
         */
    }
}
