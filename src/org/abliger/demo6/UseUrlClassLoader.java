package org.abliger.demo6;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author abliger
 * @date 2020/11/10
 * @description
 *  使用URLClassLoader简单的自定义ClassLoader
 */

public class UseUrlClassLoader extends URLClassLoader {
    public Class clazz;

    public UseUrlClassLoader(URL[] urls, String name) throws ClassNotFoundException {
        super(urls);
        this.clazz = findClass(name);
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}