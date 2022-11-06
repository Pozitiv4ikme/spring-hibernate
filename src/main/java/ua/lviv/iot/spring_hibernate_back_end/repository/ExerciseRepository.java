package ua.lviv.iot.spring_hibernate_back_end.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring_hibernate_back_end.domain.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
    List<Exercise> findByComplexityAndTypeOfMuscleLoadOn(Integer complexity, String typeOfMuscleLoadOn);
}
