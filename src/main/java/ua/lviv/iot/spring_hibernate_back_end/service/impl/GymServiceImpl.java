package ua.lviv.iot.spring_hibernate_back_end.service.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring_hibernate_back_end.controller.GymController;
import ua.lviv.iot.spring_hibernate_back_end.domain.City;
import ua.lviv.iot.spring_hibernate_back_end.domain.Client;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gym;
import ua.lviv.iot.spring_hibernate_back_end.dto.ClientDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.GymDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.assembler.ClientDtoAssembler;
import ua.lviv.iot.spring_hibernate_back_end.dto.assembler.GymDtoAssembler;
import ua.lviv.iot.spring_hibernate_back_end.exeption.city.CityServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.client.ClientServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.gym.GymServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.repository.CityRepository;
import ua.lviv.iot.spring_hibernate_back_end.repository.ClientRepository;
import ua.lviv.iot.spring_hibernate_back_end.repository.GymRepository;
import ua.lviv.iot.spring_hibernate_back_end.service.GymService;

@Service
@AllArgsConstructor
public class GymServiceImpl implements GymService {

    private final CityRepository cityRepository;
    private final GymRepository gymRepository;
    private final ClientRepository clientRepository;
    private final GymDtoAssembler gymDtoAssembler;
    private final ClientDtoAssembler clientDtoAssembler;

    @Override
    public GymDto create(GymDto entity) {
        Gym gym = new Gym();
        gym.setPhone(entity.getPhone());
        gym.setStreetAddress(entity.getStreetAddress());
        City city =
            cityRepository.findById(entity.getCityId()).orElseThrow(() -> new CityServiceNotFoundException(entity.getCityId()));
        gym.setCity(city);

        Integer gymId = gymRepository.save(gym).getId();
        entity.setId(gymId);

        Link selfLink = linkTo(methodOn(GymController.class).getGym(gymId)).withSelfRel();
        entity.add(selfLink);
        return entity;
    }

    @Override
    public GymDto update(GymDto uGym, Integer id) {
        Gym gym = gymRepository.findById(id).orElseThrow(() -> new GymServiceNotFoundException(id));
        gym.setPhone(uGym.getPhone());
        gym.setStreetAddress(uGym.getStreetAddress());
        City city =
            cityRepository.findById(uGym.getCityId()).orElseThrow(() -> new CityServiceNotFoundException(uGym.getCityId()));
        gym.setCity(city);
        return uGym;
    }

    @Override
    public void delete(Integer id) {
        Gym gym = gymRepository.findById(id).orElseThrow(() -> new GymServiceNotFoundException(id));
        gymRepository.delete(gym);
    }

    @Override
    public GymDto findById(Integer id) {
        Gym gym = gymRepository.findById(id).orElseThrow(() -> new GymServiceNotFoundException(id));
        return GymDto.builder()
            .id(gym.getId())
            .phone(gym.getPhone())
            .streetAddress(gym.getStreetAddress())
            .cityId(gym.getCity().getId())
            .build();
    }

    @Override
    public CollectionModel<GymDto> findAll() {
        List<Gym> gyms = gymRepository.findAll();
        return gymDtoAssembler.toCollectionModel(gyms);
    }

    @Override
    public CollectionModel<GymDto> findByCityId(Integer cityId) {
        List<Gym> gyms = gymRepository.findByCityId(cityId);
        Link selfLink = linkTo(methodOn(GymController.class).getByCityId(cityId)).withSelfRel();
        return gymDtoAssembler.toCollectionModel(gyms, selfLink);
    }
    @Override
    public CollectionModel<ClientDto> findAllClientsById(Integer gymId) {
        Gym gym = gymRepository.findById(gymId).orElseThrow(() -> new GymServiceNotFoundException(gymId));
        List<Client> clients = gym.getClients().stream().toList();
        Link gymLink = linkTo(methodOn(GymController.class).getGym(gymId)).withRel("gym");
        return clientDtoAssembler.toCollectionModel(clients, gymLink);
    }

    @Override
    public GymDto insertWithProcedure(GymDto gymDto) {
        City city =
            cityRepository.findById(gymDto.getCityId()).orElseThrow(() -> new CityServiceNotFoundException(gymDto.getCityId()));

        Integer id = gymRepository.insertWithProcedure(gymDto.getPhone(), gymDto.getStreetAddress(),
            city.getId());

        Link selfLink = linkTo(methodOn(GymController.class).getGym(id)).withSelfRel();
        gymDto.add(selfLink);
        return gymDto;
    }

    @Override
    public void addClientToGym(Integer gymId, Integer clientId) {
        Client client =
            clientRepository.findById(clientId).orElseThrow(() -> new ClientServiceNotFoundException(clientId));

        Gym gym = gymRepository.findById(gymId).orElseThrow(() -> new GymServiceNotFoundException(gymId));

        Set<Client> gymClients = gym.getClients();
        gymClients.add(client);
        gym.setClients(gymClients);
        gymRepository.save(gym);
    }
}
