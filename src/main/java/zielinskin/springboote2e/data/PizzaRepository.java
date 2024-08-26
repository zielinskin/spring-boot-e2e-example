package zielinskin.springboote2e.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PizzaRepository extends CrudRepository<PizzaEntity, Integer> {
    List<PizzaEntity> findAll();

    List<PizzaEntity> findBySizeAndCrust(Integer size, String crust);
}
