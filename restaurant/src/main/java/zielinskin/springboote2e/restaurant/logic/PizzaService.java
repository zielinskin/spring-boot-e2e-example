package zielinskin.springboote2e.restaurant.logic;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import zielinskin.springboote2e.restaurant.data.PizzaEntity;
import zielinskin.springboote2e.restaurant.data.PizzaRepository;
import zielinskin.springboote2e.restaurant.view.Pizza;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public Optional<Pizza> get(Integer id) {
        return pizzaRepository.findById(id)
                .map(this::mapToView);
    }

    public List<Pizza> get() {
        return pizzaRepository.findAll().stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    public void save(Pizza view) {
        pizzaRepository.save(mapToEntity(view));
    }

    public void delete(Integer id) {
        pizzaRepository.deleteById(id);
    }


    //demonstration of manual mappers
    private Pizza mapToView(PizzaEntity entity) {
        return new Pizza(entity.getId(),
                entity.getCrust(),
                entity.getType(),
                entity.getSize());
    }

    private PizzaEntity mapToEntity(Pizza view) {
        PizzaEntity entity = new PizzaEntity();

        entity.setId(view.getId());
        entity.setCrust(view.getCrust());
        entity.setSize(view.getSize());
        entity.setType(view.getType());

        return entity;
    }
}
