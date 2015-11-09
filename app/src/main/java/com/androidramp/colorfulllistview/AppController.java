package com.androidramp.colorfulllistview;

import android.app.Application;
import android.graphics.Typeface;
import android.widget.TextView;

public class AppController extends Application {

    public static Typeface font;
    public static String forte = "forte.ttf";

    @Override
    public void onCreate() {
        super.onCreate();
        font = Typeface.createFromAsset(getAssets(), forte);
    }

    public static void Forte(TextView textView) {
        textView.setTypeface(AppController.font);
    }
}