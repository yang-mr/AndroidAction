package com.example.yw.action.java.equals_hashcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;

/**
 Desc
    1.重写equals必须重写hashCode
    2.equals return true, hashCode Same, or equals return false, hashCode 可以不相同;
    3.
 18-3-19:上午10:58
 Author jack
*/
public class EqualsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equals);
    }

    @Override
    public boolean equals(Object obj) {
        /**
         *        if (this == obj)
         9             return true;
         10
         11         if ((obj == null) || (obj.getClass() != this.getClass()))
         12             return false;
         13
         //能执行到这里，说明obj和this同类且非null。
         14         Test test = (Test) obj;
         */

        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
