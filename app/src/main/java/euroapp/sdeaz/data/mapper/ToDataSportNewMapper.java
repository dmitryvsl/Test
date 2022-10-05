package euroapp.sdeaz.data.mapper;

import euroapp.sdeaz.data.model.SportNewData;
import euroapp.sdeaz.domain.mapper.Mapper;
import euroapp.sdeaz.domain.model.SportNew;

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
