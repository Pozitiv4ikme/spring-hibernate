package ua.lviv.iot.spring_hibernate_back_end.service;

import java.util.List;
import java.util.Optional;
import ua.lviv.iot.spring_hibernate_back_end.domain.Client;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gender;

public interface ClientService extends GeneralService<Client, Integer>{
    List<Client> findByGender(Gender gender);
    Client findByNameIgnoreCase(String name);
}
