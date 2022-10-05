package euroapp.sdeaz.presentation.utils;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SharedPreferencesHelper {

    private static final String SHARED_PREFERENCES= "com.example.test.SHARED_PREFERENCES";
    private static final String URL = "URL";

    Context context;

    @Inject
    public SharedPreferencesHelper(Context context) {
        this.context = context;
    }

    public void saveUrl(String url){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFERENCES,  Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(URL, url);
        editor.apply();
    }

    public String  getUrl(){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFERENCES,  Context.MODE_PRIVATE);
        return preferences.getString(URL, "");
    }
}

