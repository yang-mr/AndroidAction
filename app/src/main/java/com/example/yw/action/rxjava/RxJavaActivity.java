package com.example.yw.action.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;

import org.reactivestreams.Subscriber;

import java.util.List;

import io.reactivex.Observable;

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
        Observable.create(new Observable.OnSubscribe<List<User>>() {
            @Override
            public void call(Subscriber<? super List<User>> subscriber) {
                List<User> userList = null;

                subscriber.onNext(userList);
            }
        }).flatMap(new Func1<List<User>, Observable<User>>() {
            @Override
            public Observable<User> call(List<User> users) {
                return Observable.from(users);
            }
        }).filter(new Func1<User, Boolean>() {
            @Override
            public Boolean call(User user) {
                return user.getName().equals("小明");
            }
        }).map(new Func1<User, User>() {
            @Override
            public User call(User user) {
                //根据小明的数据user从数据库查找出小明的父亲user2
                return user2;
            }
        }).subscribe(new Action1<User>() {
            @Override
            public void call(User user2) {
                //拿到谜之小明的爸爸的数据
            }
        });
    }

    class User{
        private String name;
    }
}
