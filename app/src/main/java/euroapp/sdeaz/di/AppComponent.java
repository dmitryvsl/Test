package euroapp.sdeaz.di;

import euroapp.sdeaz.di.module.AppModule;
import euroapp.sdeaz.di.module.RepositoryModule;
import euroapp.sdeaz.presentation.MainActivity;
import euroapp.sdeaz.presentation.stub.FragmentList;
import euroapp.sdeaz.presentation.stub.StubActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject(FragmentList fragmentList);

}
