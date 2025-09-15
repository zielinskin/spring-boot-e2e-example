package zielinskin.springboote2e.restaurant.logic;

import org.springframework.stereotype.Service;
import zielinskin.common.logic.AbstractCrudService;
import zielinskin.common.logic.BiMapper;
import zielinskin.springboote2e.restaurant.api.Pasta;
import zielinskin.springboote2e.restaurant.api.PastaService;
import zielinskin.springboote2e.restaurant.data.PastaEntity;
import zielinskin.springboote2e.restaurant.data.PastaRepository;

@Service
class PastaServiceImpl extends AbstractCrudService<PastaEntity, Pasta, Integer, PastaRepository> implements PastaService {
    public PastaServiceImpl(PastaRepository repository, BiMapper<Pasta, PastaEntity> mapper) {
        super(repository, mapper);
    }
}
