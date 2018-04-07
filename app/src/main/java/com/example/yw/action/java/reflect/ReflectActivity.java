package com.example.yw.action.java.reflect;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

        // testConstructor(); // 获得类的构造函数

        // testMethod(); // 获得类的方法

        // testGeneric();

        // testParameterizedType();

        // testTypeVariable();
        
        // testGenericArrayType();

        testWildcardType();

    }


    static class WildcardTypeBean<T extends Person> {
        private List<? extends Person> p;
        private List<? super Number> a;
    }
    /**
     * 通配符的类型
     */
    private static void testWildcardType() {
        Class s = new WildcardTypeBean().getClass();
        Field[] fields = s.getDeclaredFields();
        for (Field field : fields) {
            Type type = field.getGenericType();
            System.out.println(type);
            if (type instanceof ParameterizedType) {
                Type typee = ((ParameterizedType) type).getActualTypeArguments()[0];

                if (typee instanceof WildcardType) {
                    Type[] tt = ((WildcardType) typee).getLowerBounds();
                    for (Type e : tt) {
                        System.out.println(e);
                    }

                    Type[] ee = ((WildcardType) typee).getUpperBounds();
                    for (Type t : ee) {
                        System.out.println(t);
                    }
                }
            }

        }
    }

    static class GenericArrayType<T> {
        public void test(List<String>[] list, String[] s, List<String> l, T[] t) {

        }
    }
    private static void testGenericArrayType() {
        try {
            Class s = new GenericArrayType<String>().getClass();
            Method method = s.getDeclaredMethods()[0];
            Type[] types = method.getGenericParameterTypes();
            for (Type p : types) {
                System.out.println(p + "is genericArrayType " + (p instanceof java.lang.reflect.GenericArrayType));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class VariableBean<T extends Person, V> implements Person<T> {
        T value;

        @Override
        public boolean isPerson() {
            return false;
        }
    }
    /**
     * 变量类型
     */
    private static void testTypeVariable() {
        VariableBean bean = new VariableBean<Person, String>();
        Class s = bean.getClass();
        TypeVariable[] cTypes = s.getTypeParameters();
        for (TypeVariable cType : cTypes) {
            System.out.println(cType);
            System.out.println(cType.getBounds()[0]);
        }

        try {
            Field field  = s.getDeclaredField("value");
            Type type = field.getGenericType();
            System.out.println(type);
            if (type instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type;
                System.out.println("typeVariable.getName():" + typeVariable.getName());
                System.out.println("typeVariable.getGenericDeclaration():" + typeVariable.getGenericDeclaration());
                Type[] types = typeVariable.getBounds();
                for (Type t : types) {
                    System.out.println(t);
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    static class Bean {
        Map<String, Person> map;
        Set<String> set1;
        Class<?> clz;
        Holder<String> holder;
        List<String> list;
        // Map<String,Person> map 这个 ParameterizedType 的 getOwnerType() 为 null，
        // 而 Map.Entry<String, String> entry 的 getOwnerType() 为 Map 所属于的 Type。
        Map.Entry<String, String> entry;
        // 下面的 field 的 Type 不属于ParameterizedType
        String str;
        Integer i;
        Set set;
        List aList;

        static class Holder<V> {

        }
    }
    /**
     *  参数化类型
     */
    private static void testParameterizedType() {
        Field f = null;
        try {
            Field[] fields = Bean.class.getDeclaredFields();
            // 打印出所有的 Field 的 TYpe 是否属于 ParameterizedType
            for (int i = 0; i < fields.length; i++) {
                f = fields[i];
                System.out.println(f.getName()
                        + " getGenericType() instanceof ParameterizedType "
                        + (f.getGenericType() instanceof ParameterizedType));
            }
            getParameterizedTypeMes(Bean.class, "map" );
            getParameterizedTypeMes(Bean.class, "entry" );
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void getParameterizedTypeMes(Class clazz, String fieldName) throws NoSuchFieldException {
        Field f = clazz.getDeclaredField(fieldName);
        f.setAccessible(true);
        ParameterizedType pType = (ParameterizedType) f.getGenericType();
        System.out.println(pType.getRawType());
        for (Type type : pType.getActualTypeArguments()) {
            System.out.println(type);
        }
        System.out.println(pType.getOwnerType()); // null
    }

    /**
     * 范型的获取，
     */
    private static void testGeneric() {
        Zoo zoo = new Zoo<Meat>() {
            @Override
            public void eat(Meat o) {

            }
        };
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
