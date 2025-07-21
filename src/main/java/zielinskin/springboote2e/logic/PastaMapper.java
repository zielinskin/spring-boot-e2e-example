package zielinskin.springboote2e.logic;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import zielinskin.springboote2e.data.PastaEntity;
import zielinskin.springboote2e.view.Pasta;

@Mapper(componentModel = "spring")
public interface PastaMapper {
    PastaEntity mapToEntity(Pasta pasta);
    Pasta mapToView(PastaEntity pastaEntity);
}
