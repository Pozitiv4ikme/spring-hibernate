package ua.lviv.iot.spring_hibernate_back_end.service;

import java.util.List;
import java.util.Optional;
import org.springframework.hateoas.CollectionModel;

public interface GeneralService<E, ID> {
    E create(E entity);
    E update(E entity, ID id);
    void delete(ID id);
    E findById(ID id);
    CollectionModel<E> findAll();
}
