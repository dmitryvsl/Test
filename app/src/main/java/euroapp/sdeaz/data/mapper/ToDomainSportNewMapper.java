package euroapp.sdeaz.data.mapper;

import euroapp.sdeaz.data.model.SportNewData;
import euroapp.sdeaz.domain.mapper.Mapper;
import euroapp.sdeaz.domain.model.SportNew;

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
