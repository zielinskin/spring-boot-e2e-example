package zielinskin.springboote2e.logic;

import org.springframework.stereotype.Service;
import zielinskin.springboote2e.data.PastaEntity;
import zielinskin.springboote2e.data.PastaRepository;
import zielinskin.springboote2e.view.Pasta;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PastaService {
    private final PastaRepository pastaRepository;
    private final PastaMapper pastaMapper;

    public PastaService(PastaRepository pastaRepository, PastaMapper pastaMapper) {
        this.pastaRepository = pastaRepository;
        this.pastaMapper = pastaMapper;
    }

    public Optional<Pasta> get(Integer id) {
        return pastaRepository.findById(id)
                .map(pastaMapper::mapToView);
    }

    public List<Pasta> get() {
        return pastaRepository.findAll().stream()
                .map(pastaMapper::mapToView)
                .collect(Collectors.toList());
    }

    public void save(Pasta view) {
        pastaRepository.save(pastaMapper.mapToEntity(view));
    }

    public void delete(Integer id) {
        pastaRepository.deleteById(id);
    }
}
