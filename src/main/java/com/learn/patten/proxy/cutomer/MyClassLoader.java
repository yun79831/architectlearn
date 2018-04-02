package com.learn.patten.proxy.cutomer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by admin on 2018/3/10.
 */
public class MyClassLoader extends ClassLoader {
    private File classPathFile;

    public MyClassLoader() {
        String classPath = MyClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    //将字节码文件生成到此类下
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFile == null) {
            return null;
        }
        File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
        if (classFile.exists()) {
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(classFile);
                out = new ByteArrayOutputStream();
                byte[] buff = new byte[1024];
                int len;
                while ((len = in.read(buff)) != -1) {
                    out.write(buff, 0, len);
                }
                return defineClass(className, out.toByteArray(), 0, out.size());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null) in.close();
                    if (out != null) out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return null;
    }


}
