package euroapp.sdeaz.domain.mapper;

public interface Mapper <In, Out>{

    Out map(In data);
}
