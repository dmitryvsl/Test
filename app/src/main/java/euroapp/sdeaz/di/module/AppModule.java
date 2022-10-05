package euroapp.sdeaz.di.module;

import android.content.Context;

import euroapp.sdeaz.App;
import euroapp.sdeaz.domain.model.SportNew;
import euroapp.sdeaz.domain.repo.Repository;
import euroapp.sdeaz.domain.use_case.GetNewsUseCase;
import euroapp.sdeaz.presentation.utils.SimCardHelper;

import java.util.List;

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
