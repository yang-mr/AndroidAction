package com.example.yw.action.java.executor_thread;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;

import java.sql.Time;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 1. thread
 * 2. executor
 * 3...  ref:
 *  http://www.cnblogs.com/dolphin0520/p/3932921.html#top
 */
public class ExecutorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_executor);
    }

    public static void main(String[] args) {
        createThread();

        // testThreadPool();

        testAsyncTask();
    }

    private static void testAsyncTask() {
        class MyAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

            @Override
            protected Object doInBackground(Object[] objects) {
                return null;
            }
        }

        new MyAsyncTask().execute("test");
    }

    private static void testThreadPool() {
        class MyRunnable implements Runnable {
            private String name;

            public MyRunnable(String name) {
                this.name = name;
            }

            @Override
            public void run() {
                System.out.println("正在执行task " + name);
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task " + name + "执行完毕");
            }
        }
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        for (int i = 0; i < 30; i++) {
            executor.execute(new MyRunnable("name " + i));
        }
        executor.shutdown();
    }

    /**
     * 创建线程的3种方法
     */
    private static void createThread() {
       // byRunnableCreate();
       // byThreadCreate();
        byCallableCreate();
    }

    private static void byCallableCreate() {
        class MyCallable implements Callable<String> {

            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "test Callable";
            }
        }

        MyCallable myCallable = new MyCallable();
        FutureTask<String> task = new FutureTask(myCallable);
//
//        try {
//            String msg = task.get(2000, TimeUnit.MILLISECONDS);
//            System.out.println("msg:" + msg);
//        } catch (TimeoutException e) {
//            System.out.println("e:" + e);
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        Thread thread = new Thread(task);
        thread.start();
    }

    private static void byThreadCreate() {
        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        }
        new MyThread().start();
        new MyThread().run();
    }

    private static void byRunnableCreate() {
        class MyRunnable implements Runnable {

            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        }
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        new MyRunnable().run();
    }
}
