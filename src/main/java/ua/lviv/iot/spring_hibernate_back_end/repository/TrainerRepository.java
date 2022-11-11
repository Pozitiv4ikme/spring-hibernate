package ua.lviv.iot.spring_hibernate_back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring_hibernate_back_end.domain.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
    @Procedure("cursor_creation_of_tables_with_names_timestamp")
    void createTablesByCursor();
}
