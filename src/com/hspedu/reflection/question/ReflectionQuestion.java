package com.hspedu.reflection.question;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1.使用properties类,可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.getProperty("classfullpath");
        String method = properties.getProperty("method");
        System.out.println(classfullpath);
        System.out.println(method);
        //2.创建对象，传统方法行不通-->反射机制
        //传统:new classfullpath();   因为classfullpath为str,无法new
        //传统Cat cat = new Cat();    cat.hi();

        //3.使用反射机制解决
        //(1)加载类
        Class<?> cls = Class.forName(classfullpath);
        //(2)通过cls得到你加载的类com.hspedu.Cat的对象实例
        Object o = cls.getDeclaredConstructor().newInstance();
        System.out.println(o.getClass());
        //(3)通过cls得到你加载的类com.hspedu.Cat的methodName "hi" 的方法对象
        //即：在反射中，方法可以看作对象
        Method m = cls.getMethod(method);
        //(4)通过方法对象实现调用方法
        m.invoke(o);    //传统方法:对象.方法，   反射机制: 方法.invoke(对象);
        //反射机制的好处: 如果想调用Cat类的cry()方法，传统方式必须把上面源码的cat.hi();-->cat.cry(); 即会改变源码
        //而发射只用将配置文件re.properties中的method=hi-->method=cry,在通过上述调用m.invoke(o)即可.即不用改变源码
    }
}
