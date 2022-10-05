package euroapp.sdeaz.di.module;

import euroapp.sdeaz.R;
import euroapp.sdeaz.data.mapper.ToDataSportNewMapper;
import euroapp.sdeaz.data.mapper.ToDomainSportNewMapper;
import euroapp.sdeaz.data.model.SportNewData;
import euroapp.sdeaz.data.repo.FakeSportNewsRepo;
import euroapp.sdeaz.data.repo.FirebaseRepo;
import euroapp.sdeaz.domain.mapper.Mapper;
import euroapp.sdeaz.domain.model.SportNew;
import euroapp.sdeaz.domain.repo.Repository;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import java.util.List;

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
