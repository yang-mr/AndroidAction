package com.yw.yw.action.leak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.yw.yw.action.R;

import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LeakActivity extends AppCompatActivity {
    private Observable mObservable;
    private Observer mObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        // initData();
        new Inner().exe();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        switch (level) {
            case TRIM_MEMORY_UI_HIDDEN:
                // 进行资源释放操作
                break;
        }
    }

    private void initData() {
        // 每隔1s执行一次事件
        mObservable = Observable.interval(1, TimeUnit.SECONDS);
        mObserver = new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Long aLong) {
                Log.i("接收数据", String.valueOf(aLong));
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        mObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mObserver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // mObservable.unsubscribeOn((Scheduler) mObserver);  //
    }

    public static void main(String[] args) {


    }
    class Inner {
        public void exe() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("第一种，Inner class...");
                    }
                }
            }).start();
        }
    }
}
