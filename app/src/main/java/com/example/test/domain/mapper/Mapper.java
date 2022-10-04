package com.example.test.domain.mapper;

public interface Mapper <In, Out>{

    Out map(In data);
}
