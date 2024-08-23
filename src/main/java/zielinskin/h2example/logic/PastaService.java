package zielinskin.h2example.logic;

import org.springframework.stereotype.Service;
import zielinskin.h2example.data.PastaEntity;
import zielinskin.h2example.data.PastaRepository;
import zielinskin.h2example.view.Pasta;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PastaService {
    private final PastaRepository pastaRepository;

    public PastaService(PastaRepository pastaRepository) {
        this.pastaRepository = pastaRepository;
    }

    public Optional<Pasta> get(Integer id) {
        return pastaRepository.findById(id)
                .map(this::mapToView);
    }

    public List<Pasta> get() {
        return pastaRepository.findAll().stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    public void save(Pasta view) {
        pastaRepository.save(mapToEntity(view));
    }

    public void delete(Integer id) {
        pastaRepository.deleteById(id);
    }

    private Pasta mapToView(PastaEntity entity) {
        return new Pasta(entity.getId(),
                entity.getName(),
                entity.getSauceType(),
                entity.getMeatType());
    }

    private PastaEntity mapToEntity(Pasta view) {
        PastaEntity entity = new PastaEntity();

        entity.setId(view.id());
        entity.setName(view.name());
        entity.setSauceType(view.sauceType());
        entity.setMeatType(view.meatType());

        return entity;
    }
}
