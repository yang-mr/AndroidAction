package com.yw.yw.action.java.dynamicproxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yw.yw.action.R;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import retrofit2.http.GET;

public class ProxyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);

        testProxy();
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        testProxy();
    }

    private static void testProxy() {
        IProxyTest iProxyTest = (IProxyTest) Proxy.newProxyInstance(IProxyTest.class.getClassLoader(), new Class[] {IProxyTest.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("method = " + method.getName() +" , args = " + Arrays.toString(args));
                Annotation[] annotations = method.getAnnotations();
                GET get = method.getAnnotation(GET.class);
                System.out.println("get value: " + get.value());
                for (Annotation annotation : annotations) {
                    GET get1 = (GET) annotation;
                    System.out.println("annotation value: " + get1.value());
                    System.out.println("annotation type: " + annotation.annotationType());
                }
                return null;
            }
        });

        System.out.println(iProxyTest.getClass());
        iProxyTest.login("111","222");
    }
}
