package ua.lviv.iot.spring_hibernate_back_end.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.spring_hibernate_back_end.domain.PersonalExerciseMachine;

public interface PersonalExerciseMachineRepository extends JpaRepository<PersonalExerciseMachine, Integer> {
    Optional<List<PersonalExerciseMachine>> findPersonalExerciseMachineByType(String type);
}
