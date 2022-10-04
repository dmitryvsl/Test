package com.example.test.domain.use_case;

import com.example.test.domain.model.SportNew;
import com.example.test.domain.repo.Repository;

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
