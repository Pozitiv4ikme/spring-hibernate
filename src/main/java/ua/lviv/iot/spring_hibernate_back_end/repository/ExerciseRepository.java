package ua.lviv.iot.spring_hibernate_back_end.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.spring_hibernate_back_end.domain.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
    Optional<List<Exercise>> findByComplexityAndTypeOfMuscleLoadOn(Integer complexity, String typeOfMuscleLoadOn);
}
