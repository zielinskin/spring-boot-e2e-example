package zielinskin.common.logic;

import java.util.List;
import java.util.Optional;

public interface CrudService<V, ID> {
    void delete(ID id);

    V save(V view);

    void save(List<V> views);

    List<V> get();

    Optional<V> get(ID id);
}
