package com.example.fragmentdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.example.fragmentdemo.pack_fragment.PackFragment;

public class MainActivity extends AppCompatActivity implements PackFragment.OnClickListenrByFragment {

    private FrameLayout mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayout = (FrameLayout) findViewById(R.id.layout);

        if (savedInstanceState != null) {
            return;
        }
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        transaction.add(R.id.layout, new FirstFragment(), "first");
        transaction.commit();
    }

    @Override
    public void onClickByFragment(View v) {
        Log.d("yw", "我是MainActivity");
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new SecondFragment();
        transaction.replace(R.id.layout, fragment, "second");

        transaction.addToBackStack(null);
        transaction.commit();
    }

}
