package com.example.test.presentation.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

@Singleton
public class NetworkHelper {

    Context context;

    @Inject
    public NetworkHelper(Context context) {
        this.context = context;
    }

    public Single<Boolean> isInternetAvailable() {
        return Single.create(new SingleOnSubscribe<Boolean>() {
            @Override
            public void subscribe(SingleEmitter<Boolean> emitter) throws Exception {
                ConnectivityManager cm = (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                if (activeNetwork != null && activeNetwork.isConnected()) {
                    try {
                        URL url = new URL("http://www.google.com/");
                        HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
                        urlc.setRequestProperty("User-Agent", "test");
                        urlc.setRequestProperty("Connection", "close");
                        urlc.setConnectTimeout(1000); // mTimeout is in seconds
                        urlc.connect();
                        if (urlc.getResponseCode() == 200){
                            emitter.onSuccess(true);
                        } else {
                            emitter.onError(new Throwable("No internet connection"));
                        }
                    } catch (IOException e) {
                        Log.i("warning", "Error checking internet connection", e);
                        emitter.onError(new Throwable(e));
                    }
                }
            }
        });

    }
}
