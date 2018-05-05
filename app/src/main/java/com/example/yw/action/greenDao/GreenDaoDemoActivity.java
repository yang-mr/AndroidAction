package com.example.yw.action.greenDao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.yw.action.R;
import com.example.yw.action.Utils;
import com.example.yw.action.greenDao.bean.DaoMaster;
import com.example.yw.action.greenDao.bean.DaoSession;
import com.example.yw.action.greenDao.bean.StudentBean;
import com.example.yw.action.greenDao.bean.StudentBeanDao;

import java.util.List;

/**
 * ref:
 *  https://blog.csdn.net/zone_/article/details/69054997
 */
public class GreenDaoDemoActivity extends AppCompatActivity implements View.OnClickListener {
    private DaoSession mDaoSession;
    private StudentBeanDao mBeanDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao_demo);

        Utils.setOnClickListener(this, this, R.id.tv_add, R.id.tv_delete, R.id.tv_update, R.id.tv_find);

        initDd();

        mBeanDao = mDaoSession.getStudentBeanDao();
    }

    private void initDd() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "student.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        mDaoSession = daoMaster.newSession();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_add:
                testSample("add");
            break;
            case R.id.tv_delete:
                testSample("delete");
                break;
            case R.id.tv_update:
                testSample("update");
                break;
            case R.id.tv_find:
                testSample("find");
                break;
        }
    }

    private void testSample(String add) {
        switch (add) {
            case "add":
                StudentBean studentMsgBean = new StudentBean();
                studentMsgBean.setName("zone");
                mBeanDao.insert(studentMsgBean);
                break;
            case "delete":
                List<StudentBean> list = mBeanDao.queryBuilder()
                        .build().list();
                for (int i = 0; i < list.size(); i++) {
                    if (i == 0) {
                        mBeanDao.deleteByKey(list.get(0).getId());//通过 Id 来删除数据
//                        msgBeanDao.delete(list.get(0));//通过传入实体类的实例来删除数据
                    }

                }
                break;
            case "update":
                list = mBeanDao.queryBuilder()
                        .build().list();
                for (int i = 0; i < list.size(); i++) {
                    Log.d("zoneLog", "name: " + list.get(i).getName());
                    if (i == 0) {
                        list.get(0).setName("zone==========>");
                        mBeanDao.update(list.get(0));
                    }
                }
                break;
            case "find":
                list = mBeanDao.queryBuilder()
                        .offset(1)//偏移量，相当于 SQL 语句中的 skip
                        .limit(3)//只获取结果集的前 3 个数据
                        .orderAsc(StudentBeanDao.Properties.Id)//通过 StudentNum 这个属性进行正序排序
                        .where(StudentBeanDao.Properties.Name.eq("zone"))//数据筛选，只获取 Name = "zone" 的数据。
                        .build()
                        .list();
                break;
        }
    }
}
