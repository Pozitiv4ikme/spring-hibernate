package ua.lviv.iot.spring_hibernate_back_end.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.spring_hibernate_back_end.domain.Exercise;
import ua.lviv.iot.spring_hibernate_back_end.dto.ExerciseDto;

@Component
public class ExerciseDtoAssembler implements RepresentationModelAssembler<Exercise, ExerciseDto> {

    @Override
    public ExerciseDto toModel(Exercise entity) {
        return null;
    }

    @Override
    public CollectionModel<ExerciseDto> toCollectionModel(Iterable<? extends Exercise> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
