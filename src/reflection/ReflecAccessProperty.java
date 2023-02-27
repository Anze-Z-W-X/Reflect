package reflection;

import java.lang.reflect.Field;

public class ReflecAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //1.得到Student类的Class对象
        Class<?> cls = Class.forName("reflection.Student");
        //2.创建对象
        Object o = cls.newInstance();
        //3.用反射得到age的属性对象
        Field age = cls.getField("age");
        age.set(o,17);
        System.out.println(o);
        //使用反射操作name
        Field name = cls.getDeclaredField("name");
        //使用爆破操作私有的属性
        name.setAccessible(true);
        //name.set(o,"zwx");
        name.set(null,"zwx");   //static可以置空,因为所有类共用一个
        System.out.println(o);
    }
}

class Student{
    public int age;
    public static String name;

    public Student() {
    }

    public Student(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "age=" + age + " name="+name+'}';
    }
}