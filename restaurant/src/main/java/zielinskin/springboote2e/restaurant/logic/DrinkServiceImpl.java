package zielinskin.springboote2e.restaurant.logic;

import org.springframework.stereotype.Service;
import zielinskin.springboote2e.restaurant.api.Drink;
import zielinskin.springboote2e.restaurant.api.DrinkService;
import zielinskin.springboote2e.restaurant.api.Pasta;
import zielinskin.springboote2e.restaurant.api.PastaService;
import zielinskin.springboote2e.restaurant.data.DrinkEntity;
import zielinskin.springboote2e.restaurant.data.DrinkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkServiceImpl implements DrinkService {
    private final DrinkRepository drinkRepository;

    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public void delete(Integer id) {
         drinkRepository.deleteById(id);

    }

    @Override
    public Optional<Drink> get(Integer id) {
        return drinkRepository.findById(id)
                .map(this::mapToView);
    }

    @Override
    public List<Drink> get() {
        return drinkRepository.findAll().stream()
                .map(this::mapToView)
                .toList();
    }

    @Override
    public void save(Drink view) {
        drinkRepository.save(mapToEntity(view));
    }

    private Drink mapToView(DrinkEntity entity) {
        return new Drink(entity.getId(),
                entity.getName(),
                entity.getCarbonationScale(),
                entity.getAgeRestricted());
    }

    private DrinkEntity mapToEntity(Drink view) {
        DrinkEntity bev = new DrinkEntity();

        bev.setId(view.id());
        bev.setName(view.name());
        bev.setAgeRestricted(view.ageRestricted());
        bev.setCarbonationScale(view.carbonationScale());

        return bev;
    }

}
