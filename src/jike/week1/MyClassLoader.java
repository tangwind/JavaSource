package jike.week1;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {


    @Override
    public Class<?> findClass(String name) {
        byte[] b = loadClassData(name);
        assert b != null;
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) {
        String path = "/Users/lulaaaa/IdeaProjects/JavaSource/src/jike/week1/";
        name = path + name + ".xlass";
        try (InputStream in = new FileInputStream(name);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int i = 0;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            byte[] bytes = out.toByteArray();
            for (int j = 0; j < bytes.length; j++) {
                bytes[j] = sub(bytes[j]);
            }
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte sub(byte b) {
        return (byte) (255 - b);
    }

}

