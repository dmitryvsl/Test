package com.example.test.presentation.stub.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.test.domain.use_case.GetNewsUseCase;

import javax.inject.Inject;

public class StubViewModelFactory implements ViewModelProvider.Factory {

    GetNewsUseCase getNewsUseCase;

    @Inject
    public StubViewModelFactory(GetNewsUseCase getNewsUseCase) {
        this.getNewsUseCase = getNewsUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(StubViewModel.class))
            return (T) new StubViewModel(getNewsUseCase);
        else
            throw new ClassCastException("No such class found");
    }
}
