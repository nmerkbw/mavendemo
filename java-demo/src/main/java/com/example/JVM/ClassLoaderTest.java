package com.example.JVM;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by louyuting on 17/1/2.
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null){
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }

            }
        };

        Object obj = myLoader.loadClass("JVM.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.print(obj instanceof ClassLoaderTest);
    }

    @org.junit.Test
    public void test(){
        System.out.println(System.getProperty("java.ext.dirs"));
    }

}
