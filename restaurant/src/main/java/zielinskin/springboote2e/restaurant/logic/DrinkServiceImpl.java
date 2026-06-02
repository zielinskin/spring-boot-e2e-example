package zielinskin.springboote2e.restaurant.logic;

import org.springframework.stereotype.Service;
import zielinskin.springboote2e.restaurant.api.Pasta;
import zielinskin.springboote2e.restaurant.api.PastaService;
import zielinskin.springboote2e.restaurant.data.DrinkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkServiceImpl implements PastaService {
    private final DrinkRepository drinkRepository;

    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Pasta save(Pasta view) {
        return null;
    }

    @Override
    public void save(List<Pasta> views) {

    }

    @Override
    public List<Pasta> get() {
        return List.of();
    }

    @Override
    public Optional<Pasta> get(Integer integer) {
        return Optional.empty();
    }
}
