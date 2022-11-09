package ua.lviv.iot.spring_hibernate_back_end.service;

import java.util.List;
import org.springframework.hateoas.CollectionModel;
import ua.lviv.iot.spring_hibernate_back_end.dto.ClientDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.GymDto;

public interface GymService extends GeneralService<GymDto, Integer>{
    CollectionModel<GymDto> findByCityId(Integer cityId);
    CollectionModel<ClientDto> findAllClientsById(Integer gymId);

    GymDto insertWithProcedure(GymDto gymDto);
    void addClientToGym(Integer gymId, Integer clientId);
}
