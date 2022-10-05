package euroapp.sdeaz;

import android.app.Application;
import android.content.Context;

import euroapp.sdeaz.di.AppComponent;
import euroapp.sdeaz.di.DaggerAppComponent;

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
