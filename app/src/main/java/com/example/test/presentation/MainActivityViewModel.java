package com.example.test.presentation;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.test.R;
import com.example.test.domain.repo.Repository;
import com.example.test.presentation.utils.NetworkHelper;
import com.example.test.presentation.utils.StringResourceExtracter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivityViewModel extends ViewModel {

    private static final String TAG = "MainActivityViewModel";

    private final Repository<String> repository;
    private final NetworkHelper networkHelper;
    private final StringResourceExtracter extracter;

    private CompositeDisposable disposable;

    private final MutableLiveData<String> _url = new MutableLiveData<>();
    public LiveData<String> url = _url;

    private final MutableLiveData<Boolean> _loading = new MutableLiveData<>();
    public LiveData<Boolean> loading = _loading;

    private final MutableLiveData<Boolean> _isInternetAvailable = new MutableLiveData<>();
    public LiveData<Boolean> isInternetAvailable = _isInternetAvailable;

    private final MutableLiveData<String> _error = new MutableLiveData<>();
    public LiveData<String> error = _error;

    @Inject
    public MainActivityViewModel(Repository<String> repository, NetworkHelper networkHelper, StringResourceExtracter extracter) {

        this.repository = repository;
        this.networkHelper = networkHelper;
        this.extracter = extracter;

        disposable = new CompositeDisposable();
    }

    void getUrl() {
        _error.setValue(null);

        disposable.add(
                repository.getData()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnEvent((s, throwable) -> _loading.setValue(false))
                        .subscribeWith(new DisposableSingleObserver<String>() {
                            @Override
                            public void onSuccess(String s) {
                                Log.d(TAG, "onSuccess: " + s);
                                _url.setValue(s);
                            }

                            @Override
                            public void onError(Throwable e) {
                                _error.setValue(e.getMessage());
                                Log.e(TAG, e.getMessage());
                            }
                        })
        );
    }

    public void checkConnection() {
        _loading.setValue(true);

        disposable.add(
                networkHelper
                        .isInternetAvailable()
                        .subscribeOn(Schedulers.io())
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<Boolean>() {
                            @Override
                            public void onSuccess(Boolean aBoolean) {
                                _isInternetAvailable.postValue(true);
                            }

                            @Override
                            public void onError(Throwable e) {
                                _isInternetAvailable.postValue(false);
                                _error.setValue(extracter.extractStringResource(R.string.no_internet_connection));
                            }
                        })
        );
    }


    public void cancelCalls() {
        disposable.dispose();
    }

}
