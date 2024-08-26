package zielinskin.springboote2e.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PastaRepository extends CrudRepository<PastaEntity, Integer> {
    List<PastaEntity> findAll();
}
