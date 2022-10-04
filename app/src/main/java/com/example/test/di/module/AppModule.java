package com.example.test.di.module;

import android.content.Context;

import com.example.test.App;
import com.example.test.data.model.SportNewData;
import com.example.test.data.repo.FakeSportNewsRepo;
import com.example.test.data.repo.FirebaseRepo;
import com.example.test.domain.mapper.Mapper;
import com.example.test.domain.model.SportNew;
import com.example.test.domain.repo.Repository;
import com.example.test.domain.use_case.GetNewsUseCase;
import com.example.test.presentation.utils.SimCardHelper;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    @Singleton
    Context context(){
        return App.getContext();
    }


    @Provides
    @Singleton
    SimCardHelper provideSimCardHelper(Context context){
        return new SimCardHelper(context);
    }

    @Provides
    @Singleton
    GetNewsUseCase provideGetNewsUseCase(Repository<List<SportNew>> repository){
        return new GetNewsUseCase(repository);
    }


}
