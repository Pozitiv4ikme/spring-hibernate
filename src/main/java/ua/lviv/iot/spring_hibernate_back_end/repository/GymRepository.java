package ua.lviv.iot.spring_hibernate_back_end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gym;

public interface GymRepository extends JpaRepository<Gym, Integer> {

}
