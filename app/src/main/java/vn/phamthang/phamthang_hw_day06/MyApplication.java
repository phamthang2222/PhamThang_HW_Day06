package vn.phamthang.phamthang_hw_day06;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import vn.phamthang.phamthang_hw_day06.constaints.Constant;
import vn.phamthang.phamthang_hw_day06.models.Database;
import vn.phamthang.phamthang_hw_day06.utils.PrefManagement;

public class MyApplication extends Application {
    private static Context context;
    public Database database;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext() {
        return context;
    }


}
