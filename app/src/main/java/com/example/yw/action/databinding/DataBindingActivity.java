package com.example.yw.action.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iniData();
    }

    private void iniData() {
        com.example.yw.action.databinding.ActivityDataBindingBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        binding.setPerson(new Person("jack"));
    }
}
