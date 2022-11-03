package ua.lviv.iot.spring_hibernate_back_end.service;

import java.util.List;
import java.util.Optional;
import org.springframework.hateoas.CollectionModel;
import ua.lviv.iot.spring_hibernate_back_end.domain.Client;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gender;
import ua.lviv.iot.spring_hibernate_back_end.dto.ClientDto;

public interface ClientService extends GeneralService<ClientDto, Integer>{
    CollectionModel<ClientDto> findClientsByGenderId(Integer genderId);
}
