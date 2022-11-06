package ua.lviv.iot.spring_hibernate_back_end.dto.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.spring_hibernate_back_end.controller.GymController;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gym;
import ua.lviv.iot.spring_hibernate_back_end.dto.GymDto;

@Component
public class GymDtoAssembler implements RepresentationModelAssembler<Gym, GymDto> {

    @Override
    public GymDto toModel(Gym entity) {
        GymDto gymDto = GymDto.builder()
            .id(entity.getId())
            .streetAddress(entity.getStreetAddress())
            .phone(entity.getPhone())
            .cityId(entity.getCity().getId())
            .build();

        Link selfLink = linkTo(methodOn(GymController.class).getGym(gymDto.getId())).withSelfRel();
        Link clientsLink = linkTo(methodOn(GymController.class).getClients(gymDto.getId())).withRel("clients");
        gymDto.add(selfLink);
        gymDto.add(clientsLink);
        return gymDto;
    }

    @Override
    public CollectionModel<GymDto> toCollectionModel(Iterable<? extends Gym> entities) {
        CollectionModel<GymDto> gymDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(GymController.class).getAllGyms()).withSelfRel();
        gymDtos.add(selfLink);
        return gymDtos;
    }

    public CollectionModel<GymDto> toCollectionModel(Iterable<? extends Gym> entities, Link link) {
        CollectionModel<GymDto> gymDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        gymDtos.add(link);
        return gymDtos;
    }
}
