package com.yw.yw.action.mvvm;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yw.yw.action.R;
import com.yw.yw.action.databinding.ActivityMainBinding;
import com.yw.yw.action.mvvm.model.PersonViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iniData();
    }

    private void iniData() {
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setPersonViewModel(new PersonViewModel("jack"));
    }
}
