package com.example.test.di;

import com.example.test.di.module.AppModule;
import com.example.test.di.module.RepositoryModule;
import com.example.test.presentation.MainActivity;
import com.example.test.presentation.stub.StubActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject(StubActivity activity);

}
