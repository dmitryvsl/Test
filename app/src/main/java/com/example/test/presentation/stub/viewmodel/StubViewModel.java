package com.example.test.presentation.stub.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.test.domain.model.SportNew;
import com.example.test.domain.use_case.GetNewsUseCase;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class StubViewModel extends ViewModel {

    GetNewsUseCase getNewsUseCase;
    Disposable disposable;

    public StubViewModel(GetNewsUseCase getNewsUseCase) {
        this.getNewsUseCase = getNewsUseCase;
    }

    MutableLiveData<List<SportNew>> _sportNews = new MutableLiveData<>();
    public LiveData<List<SportNew>> sportNews = _sportNews;

    MutableLiveData<Boolean> _loading = new MutableLiveData<>();
    public LiveData<Boolean> loading = _loading;

    public void getNews() {
        _loading.setValue(true);
        disposable = getNewsUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEvent((sportNews, throwable) -> _loading.setValue(false))
                .subscribeWith(new DisposableSingleObserver<List<SportNew>>() {
                    @Override
                    public void onSuccess(List<SportNew> sportNew) {
                        _sportNews.setValue(sportNew);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("StubViewModel", "onError: " + e.getMessage());
                    }
                });
    }

    public void cancelCalls() {
        disposable.dispose();
    }
}
