package zielinskin.common.logic;

public interface BiMapper<V, E> {
    V mapToView(E e);
    E mapToEntity(V v);
}
