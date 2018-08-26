package com.yw.yw.action.java.generic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yw.yw.action.R;

/**
 Desc 泛型
 18-2-7:下午5:04
 Author jack

 ref:
    http://blog.csdn.net/s10461/article/details/53941091#comments
*/
public class GenericActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);

        findViewById(R.id.bt_generic_class).setOnClickListener(this);
        findViewById(R.id.bt_generic_interface).setOnClickListener(this);
        findViewById(R.id.bt_generic_method).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_generic_class:
                break;
            case R.id.bt_generic_interface:
                startActivity(new Intent(this, GenericInterfaceActivity.class));
                break;
            case R.id.bt_generic_method:
                break;
        }
    }
}
