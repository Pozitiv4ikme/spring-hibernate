package ua.lviv.iot.spring_hibernate_back_end.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gym;

@Repository
public interface GymRepository extends JpaRepository<Gym, Integer> {
    List<Gym> findByCityId(Integer cityId);
}
