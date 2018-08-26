package com.yw.yw.action.rxjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yw.yw.action.R;
import com.yw.yw.action.rxjava.rxbus.RxBusActivity;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RxJavaActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * switch thread
     *      subscribeOn
     *      observeOn
     *
     * from
     *
     * to
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        findViewById(R.id.bt_rxbus).setOnClickListener(this);

        // operate ...
        findViewById(R.id.bt_delay).setOnClickListener(this);
        findViewById(R.id.bt_defer).setOnClickListener(this);
        test1();
    }

    private void test1() {
        Observable.create(new ObservableOnSubscribe<List<User>>() {
            @Override
            public void subscribe(ObservableEmitter<List<User>> observableEmitter) throws Exception {

            }
        }).observeOn(Schedulers.io())
                .subscribeOn(Schedulers.single()).subscribe(new Consumer<List<User>>() {
            @Override
            public void accept(List<User> users) throws Exception {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_rxbus:
                startActivity(new Intent(this, RxBusActivity.class));
                break;
            case R.id.bt_delay:
                testDelay();
                break;
            case R.id.bt_defer:
                testDefer();
                break;
        }
    }

    private void testDefer() {
        Car car = new Car();
        car.setName("my is after set...");
        car.ObservableFromCar()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String o) throws Exception {
                        com.orhanobut.logger.Logger.d(o);
                    }
                });
    }

    class Car {
        private String name = "my is default";

        public void setName(String name) {
            this.name = name;
        }

        public Observable<String> ObservableFromCar() {
            return Observable.defer(new Callable<ObservableSource<? extends String>>() {
                @Override
                public ObservableSource<String> call() throws Exception {
                    return Observable.just(name);
                }
            });
        }
    }

    private void testDelay() {
        Observable.just("testDelay")
                .delay(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        com.orhanobut.logger.Logger.d(s);
                    }
                });
    }

    class User{
        private String name;
    }
    
    
}
