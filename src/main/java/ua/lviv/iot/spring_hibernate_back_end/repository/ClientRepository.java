package ua.lviv.iot.spring_hibernate_back_end.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.spring_hibernate_back_end.domain.Client;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gender;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<List<Client>> findByGender(Gender gender);
    Optional<Client> findByNameIgnoreCase(String name);
}
