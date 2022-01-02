package jike.week1;

import java.lang.reflect.Method;

public class ClassLoaderMain {
    public static void main(String[] args) {
        MyClassLoader myClassLoader  = new MyClassLoader();
        Class<?> hello = myClassLoader.findClass("Hello");
        try {
            Object obj = hello.newInstance();
            Method method = hello.getMethod("hello");
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
