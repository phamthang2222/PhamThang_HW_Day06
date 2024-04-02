package vn.phamthang.phamthang_hw_day06;

import android.app.Application;
import android.content.Context;

import vn.phamthang.phamthang_hw_day06.constaints.Constant;
import vn.phamthang.phamthang_hw_day06.utils.PrefManagement;

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext() {
        return context;
    }


}
