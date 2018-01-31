package com.example.yw.action.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;

import org.reactivestreams.Subscriber;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RxJavaActivity extends AppCompatActivity {
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

    class User{
        private String name;
    }
}
