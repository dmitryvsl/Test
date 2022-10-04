package com.example.test.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebViewClient;

import com.example.test.App;
import com.example.test.R;
import com.example.test.databinding.ActivityMainBinding;
import com.example.test.presentation.stub.StubActivity;
import com.example.test.presentation.utils.SharedPreferencesHelper;
import com.example.test.presentation.utils.SimCardHelper;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.Locale;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel;

    @Inject
    MainActivityViewModelFactory factory;

    @Inject
    SimCardHelper simCardHelper;

    @Inject
    FirebaseRemoteConfig config;

    @Inject
    SharedPreferencesHelper sharedPreferencesHelper;

    ActivityMainBinding binding;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ((App) getApplicationContext()).getComponent().inject(this);

        viewModel = new ViewModelProvider(this, factory).get(MainActivityViewModel.class);

        setListeners();

        String url = sharedPreferencesHelper.getUrl();
        Log.d(TAG, "url from storage: " + url);

        if (url.isEmpty())
            viewModel.checkConnection();
        else
            openWebView(url);

    }

    private void showError(String error) {
        binding.webview.setVisibility(View.GONE);
        binding.progressCircular.setVisibility(View.GONE);
        binding.errorLayout.setVisibility(View.VISIBLE);
        binding.errorMessage.setText(error);
    }

    private void makeCall() {
        viewModel.getUrl();

        binding.webview.setVisibility(View.GONE);
        binding.progressCircular.setVisibility(View.VISIBLE);
        binding.errorLayout.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        viewModel.cancelCalls();
    }

    void setListeners() {
        viewModel.url.observe(this, urlObserver);
        viewModel.loading.observe(this, loadingObserver);
        viewModel.error.observe(this, errorObserver);
        viewModel.isInternetAvailable.observe(this, internetConnectionObserver);

        binding.retry.setOnClickListener(onTryAgainListener);

    }

    boolean isEmulator() {
        Log.d(TAG, "PRODUCT: " + Build.PRODUCT);
        return Build.PRODUCT.matches(".*_?sdk_?.*");
    }

    boolean isGoogleBrand() {
        Log.d(TAG,  " BRAND:" + Build.BRAND);
        return Build.BRAND.toLowerCase(Locale.ROOT).contains("google");
    }

    boolean isSimCardInstalled() {
        Log.d(TAG, "isSimCardInstalled: " + simCardHelper.isSimCardInstalled());
        return simCardHelper.isSimCardInstalled();
    }

    private void openStubActivity() {
        Intent intent = new Intent(this, StubActivity.class);
        startActivity(intent);
        this.finish();
    }

    private void openWebView(String url) {
        binding.webview.setVisibility(View.VISIBLE);
        binding.webview.setWebViewClient(new WebViewClient());
        binding.webview.loadUrl(url);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                if (!(binding.webview.getVisibility() == View.VISIBLE))
                    finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    Observer<String> urlObserver = url -> {
        Log.d(TAG, "URL from firebase: " + url);
        if (url.isEmpty() || isGoogleBrand() || isEmulator() || !isSimCardInstalled())
            openStubActivity();
        else {
            sharedPreferencesHelper.saveUrl(url);
            openWebView(url);
        }

    };

    Observer<Boolean> loadingObserver = isLoading -> {
        if (isLoading)
            binding.progressCircular.setVisibility(View.VISIBLE);
        else
            binding.progressCircular.setVisibility(View.GONE);
    };

    Observer<String> errorObserver = errorMessage -> {
        if (errorMessage != null) {
            showError(errorMessage);
        }
    };

    Observer<Boolean> internetConnectionObserver = isInternetAvailable -> {
        if (isInternetAvailable)
            makeCall();
    };

    View.OnClickListener onTryAgainListener = view -> makeCall();

}