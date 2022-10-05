package euroapp.sdeaz.domain.repo;

import io.reactivex.Single;

public interface Repository<T> {

    Single<T> getData();
}
