package ua.lviv.iot.spring_hibernate_back_end.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring_hibernate_back_end.domain.Client;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gender;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findClientsByGenderId(Integer genderId);
}
