package ua.lviv.iot.spring_hibernate_back_end.dto.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.spring_hibernate_back_end.controller.CityController;
import ua.lviv.iot.spring_hibernate_back_end.controller.TrainerController;
import ua.lviv.iot.spring_hibernate_back_end.domain.City;
import ua.lviv.iot.spring_hibernate_back_end.domain.Trainer;
import ua.lviv.iot.spring_hibernate_back_end.dto.CityDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.TrainerDto;

@Component
public class TrainerDtoAssembler implements RepresentationModelAssembler<Trainer, TrainerDto> {

    @Override
    public TrainerDto toModel(Trainer trainer) {
        TrainerDto trainerDto = TrainerDto.builder()
            .id(trainer.getId())
            .name(trainer.getName())
            .surname(trainer.getSurname())
            .phone(trainer.getPhone())
            .gymId(trainer.getGym().getId())
            .build();
        Link selfLink = linkTo(methodOn(TrainerController.class).getTrainer(trainerDto.getId())).withSelfRel();
        trainerDto.add(selfLink);
        return trainerDto;
    }

    @Override
    public CollectionModel<TrainerDto> toCollectionModel(Iterable<? extends Trainer> entities) {
        CollectionModel<TrainerDto> trainerDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(TrainerController.class).getAllTrainers()).withSelfRel();
        trainerDtos.add(selfLink);
        return trainerDtos;
    }
}
