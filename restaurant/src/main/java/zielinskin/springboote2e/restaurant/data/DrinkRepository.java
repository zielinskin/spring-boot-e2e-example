package zielinskin.springboote2e.restaurant.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrinkRepository extends CrudRepository<DrinkEntity, Integer> {
    List<DrinkEntity> findAll();
}
