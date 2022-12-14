package euroapp.sdeaz.presentation;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import euroapp.sdeaz.domain.repo.Repository;
import euroapp.sdeaz.presentation.utils.NetworkHelper;
import euroapp.sdeaz.presentation.utils.StringResourceExtracter;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MainActivityViewModelFactory implements ViewModelProvider.Factory {

    Repository<String> repository;
    NetworkHelper networkHelper;
    StringResourceExtracter extracter;

    @Inject
    public MainActivityViewModelFactory(Repository<String> repository, NetworkHelper networkHelper, StringResourceExtracter extracter) {
        this.repository = repository;
        this.networkHelper = networkHelper;
        this.extracter = extracter;
    }



    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainActivityViewModel.class))
            return (T) new MainActivityViewModel(repository, networkHelper, extracter);
        else
            throw new ClassCastException("No such class found");
    }
}
