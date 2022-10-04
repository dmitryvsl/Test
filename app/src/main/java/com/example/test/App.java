package com.example.test;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.test.di.AppComponent;
import com.example.test.di.DaggerAppComponent;

public class App extends Application {

    AppComponent component;

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        component = DaggerAppComponent.create();
    }

    public AppComponent getComponent(){
        return component;
    }

    public static Context getContext(){
        return context;
    }

}
