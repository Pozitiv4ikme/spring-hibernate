package ua.lviv.iot.spring_hibernate_back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring_hibernate_back_end.domain.PersonalTraining;

@Repository
public interface PersonalTrainingRepository extends JpaRepository<PersonalTraining, Integer> {

}
