package com.example.yw.action.java.reflect;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

/**
 Desc reflect demo
 18-2-5:下午2:14
 Author jack
*/
public class ReflectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) throws NoSuchMethodException {
        // get object methods
       // testGetObject();

       // getClassFields();

      //  testInterfaces();

        testConstructor(); // 获得类的构造函数

        // testMethod(); // 获得类的方法
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void testMethod() throws NoSuchMethodException {
        User user = new User();
        Class userClass = user.getClass();

        Method[] methods = userClass.getMethods();
       /* for (Method method : methods) {
            System.out.println("method---name: " + method.getName() + " modifier: " + Modifier.toString(method.getModifiers()) + " return type: " + method.getReturnType().getName());

            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("parameter name: " + parameter.getName() + " type: " + parameter.getType().getName());
            }
        }
        */
        Method method = userClass.getMethod("getName", String.class);
        Class[] classs = method.getParameterTypes();
        for (Class c : classs) {
            System.out.println("parameterType name: " + c.getName());
        }
        Type[] types = method.getGenericParameterTypes();
        for (Type type : types) {
            System.out.println("GenericParameterTypes name: " + type);
        }
    }

    /**
     Desc
     18-2-5:下午3:25
     Author jack
    */
    private static void testConstructor() {
        Class userClass = User.class;
        Constructor[] methods = userClass.getConstructors();
        for (Constructor method : methods) {
            System.out.println("method name: " + method.getName());

            Type[] types = method.getGenericParameterTypes();
            for (Type type : types) {
                System.out.println("type name: " + type.toString());
            }
        }
    }

    /**
     Desc 获得类的修饰符 private public etc
     18-2-5:下午3:09
     Author jack
    */
    private static void testInterfaces() {
        Class userClass = User.class;
        Class[] interfaces = userClass.getInterfaces();
        for (Class c : interfaces) {
            System.out.println("interface name: " + c.getName());
        }
        System.out.println("class 修饰符: " + Modifier.toString(userClass.getModifiers()));
    }

    /**
     Desc
     获得本类属性的修饰符
     @CallerSensitive
     public Field[] getFields() throws SecurityException {
         List<Field> fields = new ArrayList<Field>();
         getPublicFieldsRecursive(fields);
         return fields.toArray(new Field[fields.size()]);
     }
     public private not get

     18-2-5:下午2:49
     Author jack
    */
    private static void getClassFields() {
        // Class userClass = User.class;
        Class userClass = null;
        try {
            userClass = Class.forName("com.example.yw.action.java.reflect.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Field[] fields = userClass.getFields();  // 获取 all public 的字段
        Field[] fields = userClass.getDeclaredFields();  // 获取 all private 的字段

        for (Field field : fields) {
            System.out.println("field type: " + field.getType().getName());
            System.out.println("field name: " + field.getName());
            System.out.println("field 修饰符: " + Modifier.toString(field.getModifiers()));  // 获得本类属性的修饰符
        }

        // 获取 private 的字段
        try {
            Field privateField = userClass.getDeclaredField("password");
            System.out.println("private field name: " + privateField.getName() + " type: " + privateField.getType().getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     Desc get methods:
     
     1.this.getClass();
     2.u.getClass();
     3.User.class
     4.Class.forName("com.example.yw...");
     
     18-2-5:下午2:47
     Author jack
     */
    private static void testGetObject() {
        User u = new User();

        System.out.println("第一种，通过类本身获得对象");
        Class userClass = u.getObject();
        System.out.println("第一种方式成功！类名：" + userClass.toString());

        userClass = u.getClass();
        Class SubUserClass = userClass.getSuperclass();
        System.out.println("第二种方式成功！类名：" + userClass.toString());

        System.out.println("第三种，通过类名加.class获得对象");
        Class ForClass = User.class;
        System.out.println("第三种方式成功！类名："+ForClass.toString()+"\n");


        System.out.println("第四种，通过类名的字符串获得对象");
        Class ForName = null;
        try {
            ForName = Class.forName("com.example.yw.action.java.reflect.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("第四种方式成功！类名："+ForName.toString()+"\n");
    }
}
