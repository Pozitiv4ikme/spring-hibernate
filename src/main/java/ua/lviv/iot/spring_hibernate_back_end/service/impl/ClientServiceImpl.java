package ua.lviv.iot.spring_hibernate_back_end.service.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring_hibernate_back_end.controller.ClientController;
import ua.lviv.iot.spring_hibernate_back_end.domain.Client;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gender;
import ua.lviv.iot.spring_hibernate_back_end.dto.ClientDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.GymDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.assembler.ClientDtoAssembler;
import ua.lviv.iot.spring_hibernate_back_end.dto.assembler.GymDtoAssembler;
import ua.lviv.iot.spring_hibernate_back_end.exeption.client.ClientServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.gender.GenderServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.repository.ClientRepository;
import ua.lviv.iot.spring_hibernate_back_end.repository.GenderRepository;
import ua.lviv.iot.spring_hibernate_back_end.service.ClientService;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final GenderRepository genderRepository;

    private final ClientDtoAssembler clientDtoAssembler;
    private final GymDtoAssembler gymDtoAssembler;

    @Transactional
    public ClientDto create(ClientDto entity) {
        Client client = new Client();
        client.setName(entity.getName());
        client.setSurname(entity.getSurname());
        client.setBirthday(entity.getBirthday());
        client.setPhone(entity.getPhone());
        Gender gender =
            genderRepository.findById(entity.getGenderId()).orElseThrow(() -> new GenderServiceNotFoundException(
                entity.getGenderId()));
        client.setGender(gender);

        Integer clientId = clientRepository.save(client).getId();
        entity.setId(clientId);

        Link selfLink = linkTo(methodOn(ClientController.class).getClient(clientId)).withSelfRel();
        entity.add(selfLink);
        return entity;
    }

    @Transactional
    public ClientDto update(ClientDto uClient, Integer id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new ClientServiceNotFoundException(id));
        //update
        client.setName(uClient.getName());
        client.setSurname(uClient.getSurname());
        client.setPhone(uClient.getPhone());
        client.setBirthday(uClient.getBirthday());
        client.setGender(genderRepository.findById(uClient.getGenderId()).orElseThrow(() -> new GenderServiceNotFoundException(uClient.getGenderId())));
        clientRepository.save(client);
        return uClient;
    }

    @Transactional
    public void delete(Integer id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new ClientServiceNotFoundException(id));
        clientRepository.delete(client);
    }

    public ClientDto findById(Integer id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new ClientServiceNotFoundException(id));
        return ClientDto.builder()
            .id(id)
            .name(client.getName())
            .surname(client.getSurname())
            .birthday(client.getBirthday())
            .phone(client.getPhone())
            .genderId(client.getGender().getId()).build();
    }

    @Override
    public CollectionModel<ClientDto> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clientDtoAssembler.toCollectionModel(clients);
    }

    @Override
    public CollectionModel<ClientDto> findClientsByGenderId(Integer genderId) {
        List<Client> clients = clientRepository.findClientsByGenderId(genderId);
        Link selfLink = linkTo(methodOn(ClientController.class).getByGenderId(genderId)).withSelfRel();
        return clientDtoAssembler.toCollectionModel(clients, selfLink);
    }

    @Override
    public CollectionModel<GymDto> findAllGyms(Integer clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientServiceNotFoundException(clientId));
        Link clientLink = linkTo(methodOn(ClientController.class).getClient(clientId)).withRel("client");
        return gymDtoAssembler.toCollectionModel(client.getGyms().stream().toList(), clientLink);
    }

}
