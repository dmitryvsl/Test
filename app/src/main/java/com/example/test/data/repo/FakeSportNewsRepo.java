package com.example.test.data.repo;

import com.example.test.data.mapper.ToDomainSportNewMapper;
import com.example.test.data.model.SportNewData;
import com.example.test.domain.mapper.Mapper;
import com.example.test.domain.model.SportNew;
import com.example.test.domain.repo.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class FakeSportNewsRepo implements Repository<List<SportNew>> {

    Mapper<SportNewData, SportNew> toDomainMapper;

    @Inject
    public FakeSportNewsRepo(Mapper<SportNewData, SportNew> toDomainMapper) {
        this.toDomainMapper = toDomainMapper;

        fillList();
    }

    List<SportNewData> data = new ArrayList<SportNewData>();

    @Override
    public Single<List<SportNew>> getData() {
        return Single.create(emitter -> {
            //Imitate network loading
            Thread.sleep(1500L);

            emitter.onSuccess(mapToDomain(data));
        });
    }

    List<SportNew> mapToDomain(List<SportNewData> data) {
        List<SportNew> domainData = new ArrayList<>();
        for (SportNewData sportNewData : data) {
            domainData.add(toDomainMapper.map(sportNewData));
        }
        return domainData;
    }

    void fillList() {
        data.add(new SportNewData(
                "https://ichef.bbci.co.uk/news/976/cpsprodpb/5B89/production/_126933432_d272f81d3fd1abe8a74573219b5d08ae177ee27d.jpg.webp",
                "Indonesia football crush: How the disaster unfolded",
                "Indonesians are demanding answers after...",
                "5 min",
                2509)
        );
        data.add(new SportNewData(
                "https://media-cdn.tripadvisor.com/media/photo-s/1d/12/74/92/workout.jpg",
                "Sport for Health Conference kicks off",
                "On the cusp of the FIFA World Cup, Qatar 2022TM, partners at the World Innovation Summit for...",
                "3 min",
                5017)
        );
        data.add(new SportNewData(
                "https://ichef.bbci.co.uk/live-experience/cps/480/cpsprodpb/15D8D/production/_126958498_alessiarusso.jpg",
                "Real Madrid president Florentino Perez",
                "Real were one of 12 European clubs to sign up to the ESL in April 2021 but it collapsed after...",
                "6 min",
                2454)
        );
        data.add(new SportNewData(
                "https://cdn.dnaindia.com/sites/default/files/styles/full/public/2022/10/03/2543406-untitled-design-60.jpg",
                "Christopher Nkunku: Chelsea closing in on transfer deal to sign RB Leipzig forward",
                "Indonesians are demanding answers after...",
                "10 min",
                8675)
        );
        data.add(new SportNewData(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTigtCa1pKanpl7VNpkaDIqFZzV7fybNwZtlw&usqp=CAU",
                "Indonesia football crush: How the disaster unfolded",
                "The France international, who can also play in midfield, signed a two-year extension on his contract earlier this year taking...",
                "2 min",
                11575)
        );
        data.add(new SportNewData(
                "https://d11p0alxbet5ud.cloudfront.net/Pictures/780xany/8/9/1/1380891_btsportblackhistorymonth_797801.jpg",
                "BT Sport marks Black History Month with Sport In Words",
                "Hosted by Professor Benjamin Zephaniah, Sport In Words paid tribute to athletes from around the globe...",
                "5 min",
                6558)
        );
    }

}
