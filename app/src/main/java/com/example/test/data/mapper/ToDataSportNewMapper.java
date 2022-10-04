package com.example.test.data.mapper;

import com.example.test.data.model.SportNewData;
import com.example.test.domain.mapper.Mapper;
import com.example.test.domain.model.SportNew;

public class ToDataSportNewMapper implements Mapper<SportNew, SportNewData> {
    @Override
    public SportNewData map(SportNew data) {
        return new SportNewData(
                data.getImgUrl(),
                data.getTitle(),
                data.getDescription(),
                data.getReadTime(),
                data.getViews()
        );
    }
}
