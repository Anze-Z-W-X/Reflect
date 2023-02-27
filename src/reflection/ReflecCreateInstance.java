package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflecCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1.先获得User的Class对象
        Class<?> cls = Class.forName("reflection.User");
        //2.通过public的无参构造器创建实例
        Object o = cls.getDeclaredConstructor().newInstance();
        System.out.println(o);
        //3.通过public的有参构造器创建实例
        Constructor<?> constructor = cls.getConstructor(Integer.class);
        Object zwxyyds = constructor.newInstance(17);
        System.out.println(zwxyyds);
        //4.通过非public构造器创建实例
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Integer.class,String.class);
        declaredConstructor.setAccessible(true);
        //⬆爆破，可以强行访问private属性,反射面前一切是纸老虎，破坏了封装性
        Object o1 = declaredConstructor.newInstance(21,"zwxyy17");
        System.out.println(o1);
    }
}

class User{
    private Integer age=19;
    private String name="zwx";

    public User(){}

    public User(Integer age) {
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }

    private User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
    public String toString(){
        return "User [age:"+age+" name:"+name+"]";
    }
}