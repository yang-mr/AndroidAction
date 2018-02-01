package com.example.yw.action.rxjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yw.action.R;
import com.example.yw.action.rxjava.rxbus.RxBusActivity;
import com.example.yw.action.rxjava.rxbus.RxBusHelper;

import org.reactivestreams.Subscriber;

import java.util.List;
import java.util.logging.Logger;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
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
        }
    }

    class User{
        private String name;
    }
}
