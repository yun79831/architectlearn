package com.learn.patten.proxy.cutomer;


import com.sun.javafx.binding.StringFormatter;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by admin on 2018/3/10.
 */
public class MyProxy {
    private static final String ln = "\r\n";
    private static String JAVANAME = "$Proxy0";


    public static Object newProxyInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler m) {
        //1. 生成java源码
        String javaCode = generateCode(interfaces);
        //2.输出到磁盘
        File f = writeJavaFile(javaCode);
        //3.编译成class文件
        try {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            //4.加载class文件
            Class proxyClass = classLoader.findClass(JAVANAME);
            Constructor c = proxyClass.getConstructor(MyInvocationHandler.class);
            f.delete();
            return c.newInstance(m);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //5.返回字节码重组后的对象
        //清除java文件

        return null;
    }

    private static String generateCode(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.learn.patten.proxy.cutomer;" + ln);
        sb.append("import " + interfaces[0].getName() + ";" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        sb.append("public class " + JAVANAME + " implements " + interfaces[0].getName() + "{" + ln);


        sb.append(" MyInvocationHandler mh;" + ln);
        //构造
        sb.append(" public " + JAVANAME + "(MyInvocationHandler mh){" + ln);
        sb.append("this.mh=mh;" + ln);
        sb.append("}" + ln);

        for (Method method : interfaces[0].getMethods()) {
            //循环创建invoke调用
            sb.append(" public " + method.getReturnType().getName() + " " + method.getName() + "(){" + ln);
            sb.append("try{" + ln);
            sb.append(" Method m=" + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{});" + ln);
            sb.append(" this.mh.invoke(this,m, null) ;" + ln);
            sb.append("}catch(Throwable e){ e.printStackTrace();}" + ln);
            sb.append("}" + ln);
        }


        sb.append(" }" + ln);


        return sb.toString();
    }

    private static File writeJavaFile(String javaCode) {
        String filePath = MyProxy.class.getResource("").getPath();
        File f = new File(filePath + JAVANAME + ".java");
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(javaCode);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f;
    }

}

