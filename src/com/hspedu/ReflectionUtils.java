package com.hspedu;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void main(String[] args) throws ClassNotFoundException {
        //第一组

        //得到Class对象
        Class<?> cls = Class.forName("com.hspedu.Person");
        //获取全类名
        System.out.println(cls.getName());
        //获取简单类名
        System.out.println(cls.getSimpleName());
        //获取所以public修饰的属性,包括本类与父类
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        //获取本类中所有属性
        Field[] fields1 = cls.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field.getName());
        }
        //获取所有public修饰的方法，包括本类与父类
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println("本类及父类的method:"+method.getName());
        }
        //获取本类的所有方法
        Method[] methods1 = cls.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println("本类的所有方法:"+method.getName());
        }
        //cls.getConstructors:获取所有public构造器，包括本类的
        //cls.getDeclaredConstructors:获取所有本类的构造器
        //cls.getPackage:以Package形式返回包信息
        //cls.getSuperClass:以Class形式返回父类信息
        //cls.getInterfaces:以Class[]形式返回接口信息
        //cls.getAnnotations:以Annotation[]形式返回注解信息


        //第二组:java.lang.reflect.Field类

        //获取本类中所有属性
        Field[] fields2 = cls.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println("本类中的所有属性:"+field.getName()
            +" 该属性的修饰值符:"+field.getModifiers()
            +" 该属性的类型："+field.getType());
            //修饰符值：默认为0，public为1，private为2，protected为4，static为8，finial为10，可组合，即protected static为12
        }

    }
}

class A{
    public String hobby;
    public void hi(){}
}

class Person extends A{
    public String name;
    public int age;
    private double sal;
    String job;
    public void m1(){}
    private void m2(){}
    void m3(){}
    protected void m4(){}
}