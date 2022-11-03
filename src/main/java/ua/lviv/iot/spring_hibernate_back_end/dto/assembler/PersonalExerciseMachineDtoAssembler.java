package ua.lviv.iot.spring_hibernate_back_end.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.spring_hibernate_back_end.domain.PersonalExerciseMachine;
import ua.lviv.iot.spring_hibernate_back_end.dto.PersonalExerciseMachineDto;

@Component
public class PersonalExerciseMachineDtoAssembler implements RepresentationModelAssembler<PersonalExerciseMachine, PersonalExerciseMachineDto> {

    @Override
    public PersonalExerciseMachineDto toModel(PersonalExerciseMachine entity) {
        return null;
    }

    @Override
    public CollectionModel<PersonalExerciseMachineDto> toCollectionModel(
        Iterable<? extends PersonalExerciseMachine> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
