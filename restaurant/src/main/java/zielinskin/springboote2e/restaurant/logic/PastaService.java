package zielinskin.springboote2e.restaurant.logic;

import org.springframework.stereotype.Service;
import zielinskin.common.logic.AbstractCrudService;
import zielinskin.common.logic.BiMapper;
import zielinskin.springboote2e.restaurant.data.PastaEntity;
import zielinskin.springboote2e.restaurant.data.PastaRepository;
import zielinskin.springboote2e.restaurant.view.Pasta;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PastaService extends AbstractCrudService<PastaEntity, Pasta, Integer, PastaRepository> {
    public PastaService(PastaRepository repository, BiMapper<Pasta, PastaEntity> mapper) {
        super(repository, mapper);
    }
}
