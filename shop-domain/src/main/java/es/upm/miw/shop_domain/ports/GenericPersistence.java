package es.upm.miw.shop_domain.ports;

import java.util.stream.Stream;

public interface GenericPersistence<T, ID> {
    Stream<T> readAll();

    T readById(ID id);

    T create(T entity);

    T update(T entity);

    void deleteById(ID id);
}
