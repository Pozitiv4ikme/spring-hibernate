package ua.lviv.iot.spring_hibernate_back_end.dto.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.spring_hibernate_back_end.controller.ClientController;
import ua.lviv.iot.spring_hibernate_back_end.domain.Client;
import ua.lviv.iot.spring_hibernate_back_end.dto.ClientDto;

@Component
public class ClientDtoAssembler implements RepresentationModelAssembler<Client, ClientDto> {

    @Override
    public ClientDto toModel(Client entity) {
        ClientDto clientDto = ClientDto.builder()
            .id(entity.getId())
            .name(entity.getName())
            .surname(entity.getSurname())
            .birthday(entity.getBirthday())
            .phone(entity.getPhone())
            .genderId(entity.getGender().getId())
            .build();
        Link selfLink = linkTo(methodOn(ClientController.class).getClient(clientDto.getId())).withSelfRel();
        clientDto.add(selfLink);
        return clientDto;
    }

    @Override
    public CollectionModel<ClientDto> toCollectionModel(Iterable<? extends Client> entities) {
        CollectionModel<ClientDto> clientDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ClientController.class).getAllClients()).withSelfRel();
        clientDtos.add(selfLink);
        return clientDtos;
    }

    public CollectionModel<ClientDto> toCollectionModel(Iterable<? extends Client> entities, Link link) {
        CollectionModel<ClientDto> clientDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        clientDtos.add(link);
        return clientDtos;
    }
}
