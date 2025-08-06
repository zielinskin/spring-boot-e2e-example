package zielinskin.springboote2e.restaurant.logic;

import org.mapstruct.Mapper;
import zielinskin.common.logic.BiMapper;
import zielinskin.springboote2e.restaurant.data.PastaEntity;
import zielinskin.springboote2e.restaurant.view.Pasta;

@Mapper(componentModel = "spring")
public interface PastaMapper extends BiMapper<Pasta, PastaEntity> {
}
