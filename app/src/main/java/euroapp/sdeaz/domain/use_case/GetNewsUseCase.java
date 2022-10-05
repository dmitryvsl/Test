package euroapp.sdeaz.domain.use_case;

import euroapp.sdeaz.domain.model.SportNew;
import euroapp.sdeaz.domain.repo.Repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class GetNewsUseCase {

    Repository<List<SportNew>> repository;

    @Inject
    public GetNewsUseCase(Repository<List<SportNew>> repository) {
        this.repository = repository;
    }

    public Single<List<SportNew>> execute(){
        return repository.getData();
    }
}
