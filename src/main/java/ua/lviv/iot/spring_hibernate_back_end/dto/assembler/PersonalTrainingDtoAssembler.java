package ua.lviv.iot.spring_hibernate_back_end.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.spring_hibernate_back_end.domain.PersonalTraining;
import ua.lviv.iot.spring_hibernate_back_end.dto.PersonalTrainingDto;

@Component
public class PersonalTrainingDtoAssembler implements RepresentationModelAssembler<PersonalTraining, PersonalTrainingDto> {

    @Override
    public PersonalTrainingDto toModel(PersonalTraining entity) {
        return null;
    }

    @Override
    public CollectionModel<PersonalTrainingDto> toCollectionModel(Iterable<? extends PersonalTraining> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
