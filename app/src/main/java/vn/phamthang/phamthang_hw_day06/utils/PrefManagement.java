package vn.phamthang.phamthang_hw_day06.utils;

import android.animation.TypeConverter;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.session.MediaSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import vn.phamthang.phamthang_hw_day06.MyApplication;
import vn.phamthang.phamthang_hw_day06.models.UserModel;

public class PrefManagement {
    public static final String PREF_NAME = "DATA_USER";
    private static SharedPreferences sharedPreferences = MyApplication.getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    public static Gson gson = new Gson();

    public static void saveData(String key, ArrayList<UserModel> listData) {
        String dataJson = gson.toJson(listData);
        sharedPreferences.edit().putString(key, dataJson).commit();
    }

    public static ArrayList<UserModel> getData(String key) {
        String dataJson = sharedPreferences.getString(key, null);
        if (dataJson != null) {
            Type type = new TypeToken<ArrayList<UserModel>>() {}.getType();
            return gson.fromJson(dataJson,type);
        }
        return new ArrayList<>();
    }

}
