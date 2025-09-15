package zielinskin.common.logic;


import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Transactional
public abstract class AbstractCrudService<E, V, ID, R extends CrudRepository<E, ID>> implements CrudService<V, ID> {
    protected final R repository;
    protected final BiMapper<V, E> mapper;

    public AbstractCrudService(R repository, BiMapper<V, E> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }

    public V save(V view) {
        return mapper.mapToView(repository.save(mapper.mapToEntity(view)));
    }

    public void save(List<V> views) {
        repository.saveAll(views.stream()
                .map(mapper::mapToEntity)
                .collect(Collectors.toSet()));
    }

    public List<V> get() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::mapToView)
                .collect(Collectors.toList());
    }

    public Optional<V> get(ID id) {
        return repository.findById(id)
                .map(mapper::mapToView);
    }
}
