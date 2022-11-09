package ua.lviv.iot.spring_hibernate_back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring_hibernate_back_end.domain.FreeGroupProgram;

@Repository
public interface FreeGroupProgramRepository extends JpaRepository<FreeGroupProgram, Integer> {
    @Procedure("insert_10_records_into_free_group_program")
    void insert10records();
}
