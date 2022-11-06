package ua.lviv.iot.spring_hibernate_back_end.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring_hibernate_back_end.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
