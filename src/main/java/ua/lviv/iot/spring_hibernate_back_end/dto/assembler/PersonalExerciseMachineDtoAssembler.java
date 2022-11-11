package ua.lviv.iot.spring_hibernate_back_end.dto.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.spring_hibernate_back_end.controller.CityController;
import ua.lviv.iot.spring_hibernate_back_end.controller.PersonalExerciseMachineController;
import ua.lviv.iot.spring_hibernate_back_end.domain.PersonalExerciseMachine;
import ua.lviv.iot.spring_hibernate_back_end.dto.CityDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.PersonalExerciseMachineDto;

@Component
public class PersonalExerciseMachineDtoAssembler implements RepresentationModelAssembler<PersonalExerciseMachine, PersonalExerciseMachineDto> {

    @Override
    public PersonalExerciseMachineDto toModel(PersonalExerciseMachine entity) {
        PersonalExerciseMachineDto personalExerciseMachineDto =
            PersonalExerciseMachineDto.builder()
                .id(entity.getId())
                .clientAmountOfFatInBody(entity.getClientAmountOfFatInBody())
                .clientHeight(entity.getClientHeight())
                .clientLegLength(entity.getClientLegLength())
                .clientShoulderWidth(entity.getClientShoulderWidth())
                .clientStateOfHealth(entity.getClientStateOfHealth())
                .clientWeight(entity.getClientWeight())
                .type(entity.getType())
                .build();
        Link selfLink =
            linkTo(methodOn(PersonalExerciseMachineController.class).getPersonalExerciseMachine(personalExerciseMachineDto.getId())).withSelfRel();
        personalExerciseMachineDto.add(selfLink);
        return personalExerciseMachineDto;
    }

    @Override
    public CollectionModel<PersonalExerciseMachineDto> toCollectionModel(
        Iterable<? extends PersonalExerciseMachine> entities) {
        CollectionModel<PersonalExerciseMachineDto> personalExerciseMachineDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink =
            linkTo(methodOn(PersonalExerciseMachineController.class).getAllPersonalExerciseMachines()).withSelfRel();
        personalExerciseMachineDtos.add(selfLink);
        return personalExerciseMachineDtos;
    }
}
