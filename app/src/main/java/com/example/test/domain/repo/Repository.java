package com.example.test.domain.repo;

import io.reactivex.Single;

public interface Repository<T> {

    Single<T> getData();
}
