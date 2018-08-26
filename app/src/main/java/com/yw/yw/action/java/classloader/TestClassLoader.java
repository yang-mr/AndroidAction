package com.yw.yw.action.java.classloader;

/**
 * Created by jack
 * On 18-2-9:上午10:06
 * Desc:
 *
 *
 1. Bootstrap CLassloder
 2. Extention ClassLoader
 3. AppClassLoader

 */

public class TestClassLoader {
    public static void main(String[] args) {
        System.out.println("i'am test classloader");

       /* System.out.println(System.getProperty("sun.boot.class.path"));   // bootstrapClassLoader
        System.out.println(System.getProperty("java.ext.dirs"));        // extClassLoader
        System.out.println(System.getProperty("java.class.path"));     // appClassLoader*/

        ClassLoader classLoader = TestClassLoader.class.getClassLoader();
        System.out.println("classLoader: " + classLoader);
        System.out.println("classLoader parent: " + classLoader.getParent());
        System.out.println("classLoader parent's parent: " + classLoader.getParent().getParent());

        testIntClassLoader();
    }

    private static void testIntClassLoader() {
        ClassLoader booleanClassLoader = boolean.class.getClassLoader();
        System.out.println("boolean classLoader: " + booleanClassLoader);
    }
}
