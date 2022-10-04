package com.example.test.di.module;

import com.example.test.R;
import com.example.test.data.mapper.ToDataSportNewMapper;
import com.example.test.data.mapper.ToDomainSportNewMapper;
import com.example.test.data.model.SportNewData;
import com.example.test.data.repo.FakeSportNewsRepo;
import com.example.test.data.repo.FirebaseRepo;
import com.example.test.domain.mapper.Mapper;
import com.example.test.domain.model.SportNew;
import com.example.test.domain.repo.Repository;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    FirebaseRemoteConfig provideFirebaseRemoteConfig(FirebaseRemoteConfigSettings settings){
        FirebaseRemoteConfig config =  FirebaseRemoteConfig.getInstance();
        config.setConfigSettingsAsync(settings);
        config.setDefaultsAsync(R.xml.remote_config_defaults);
        return config;
    }

    @Provides
    @Singleton
    FirebaseRemoteConfigSettings provideFirebaseRemoteConfigSettings(){
        return new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(3600)
                .build();
    }


    @Provides
    @Singleton
    Mapper<SportNewData, SportNew> provideDataMapper(){
        return new ToDomainSportNewMapper();
    }

    @Provides
    @Singleton
    Mapper<SportNew, SportNewData> provideDomainMapper(){
        return new ToDataSportNewMapper();
    }


    @Provides
    @Singleton
    Repository<String> provideRepository(FirebaseRemoteConfig config){
        return new FirebaseRepo(config);
    }

    @Provides
    @Singleton
    Repository<List<SportNew>> provideFakeRepository(Mapper<SportNewData, SportNew> mapper){
        return new FakeSportNewsRepo(mapper);
    }


}
