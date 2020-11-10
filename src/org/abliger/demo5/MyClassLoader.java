package org.abliger.demo5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    private final String path;

    public MyClassLoader(String path) {
        this.path = path;
    }

    @Override
    public Class<?> findClass(String name) {
        String myPath = path + name.replace(".","/") + ".class";
        System.out.println(myPath);
        byte[] cLassBytes = null;
        Path path = null;
        try {
            path = Paths.get(new URI(myPath));
            cLassBytes = Files.readAllBytes(path);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        final Class<?> aClass = defineClass(name, cLassBytes, 0, cLassBytes.length);
        return aClass;
    }
}