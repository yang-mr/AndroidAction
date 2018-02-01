package com.example.yw.action.rxjava.rxbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yw.action.R;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class RxBusActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_bus);

        findViewById(R.id.bt_send).setOnClickListener(this);
        findViewById(R.id.bt_cancel).setOnClickListener(this);

        testRxBus();
    }

    private void testRxBus() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RxBusHelper.getInstance().toObservable().subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                if (o instanceof SendBean) {
                    SendBean bean = (SendBean) o;
                    com.orhanobut.logger.Logger.d(bean.type);
                }
            }
        }));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_send:
                RxBusHelper.getInstance().send(new SendBean("send1..."));
                break;
            case R.id.bt_cancel:
                break;
        }
    }

    private class SendBean{
        public String type;

        public SendBean(String type) {
            this.type = type;
        }
    }
}
