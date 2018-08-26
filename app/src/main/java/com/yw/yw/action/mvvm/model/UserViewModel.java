package com.yw.yw.action.mvvm.model;

import android.databinding.ObservableField;

/**
 * Created on 2018/8/2616:58.
 * Author jackyang
 * -------------------------------
 *
 * @description
 * @email 3180518198@qq.com
 */

public class UserViewModel {
    public final ObservableField<PersonViewModel> person = new ObservableField<>();

    public final ObservableField<String> sex = new ObservableField<>();

}
