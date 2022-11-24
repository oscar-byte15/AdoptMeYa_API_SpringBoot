package com.AdoptMeYa.Back.shared.mapping;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;
public class EnhancedModelMapper extends ModelMapper {
    public EnhancedModelMapper() {
        super();
        getConfiguration().setAmbiguityIgnored(true);
    }

    public <S, T> List<T> mapList(List<S> sourceList, Class<T> targetClass) {
        return sourceList.stream().map(item -> this.map(item, targetClass)).collect(Collectors.toList());
    }
}
