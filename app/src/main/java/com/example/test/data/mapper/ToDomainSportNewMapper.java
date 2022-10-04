package com.example.test.data.mapper;

import com.example.test.data.model.SportNewData;
import com.example.test.domain.mapper.Mapper;
import com.example.test.domain.model.SportNew;

public class ToDomainSportNewMapper implements Mapper<SportNewData, SportNew> {
    @Override
    public SportNew map(SportNewData data) {
        return new SportNew(
                data.getImgUrl(),
                data.getTitle(),
                data.getDescription(),
                data.getReadTime(),
                data.getViews()
        );
    }
}
