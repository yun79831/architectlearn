package com.learn.patten.proxy.cutomer;

/**
 * Created by admin on 2018/3/10.
 */
public class MyInvocationHander {
    public static final String ln = "\r\n";

    public static Object newProxy() {
        /*1.动态生成源码.java文件
        2.java文件输出到磁盘
        3.编译成clss
        4.编译的class加载到jvm中来
        5.返回字节码重组后的新的代理对象*/

//        JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
//        StandardJavaFileManager manager=compiler.getStandardFileManager();
//        Iterable iterable=manager.getJavaFileObjects();
//        JavaCompiler.CompilationTask  task=compiler.getTask();


        return null;
    }

    private static String generateSrc(Class<?> interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.learn.patten.proxy.cutomer");
        return null;
    }

}
