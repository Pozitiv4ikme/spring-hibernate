package ua.lviv.iot.spring_hibernate_back_end.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gym;

@Repository
public interface GymRepository extends JpaRepository<Gym, Integer> {
    List<Gym> findByCityId(Integer cityId);

    @Procedure("insertion_into_gym")
    Integer insertWithProcedure(@Param("new_phone") String phone, @Param("new_street_address") String streetAddress,
        @Param("new_city_id") Integer cityId);
}
