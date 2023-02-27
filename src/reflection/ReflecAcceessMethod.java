package reflection;

import jdk.dynalink.beans.StaticClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Stack;

public class ReflecAcceessMethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Class.forName("reflection.Boss");
        Object o =cls.newInstance();
        Method declaredMethod = cls.getDeclaredMethod("hi",String.class);
        declaredMethod.invoke(o,"zwx");

        Method say = cls.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);
        System.out.println(say.invoke(o,17,"zwx",'w'));
    }
}

class Boss{
    public int age;
    private static String name;

    public Boss(){}

    private static String say(int n,String s,char c){
        return n+" "+s+" "+c;
    }

    public void hi(String s){
        System.out.println("hi "+s);
    }
}