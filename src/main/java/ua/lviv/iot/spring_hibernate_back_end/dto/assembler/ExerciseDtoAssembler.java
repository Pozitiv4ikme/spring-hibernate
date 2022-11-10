package ua.lviv.iot.spring_hibernate_back_end.dto.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.spring_hibernate_back_end.controller.CityController;
import ua.lviv.iot.spring_hibernate_back_end.controller.ExerciseController;
import ua.lviv.iot.spring_hibernate_back_end.domain.Exercise;
import ua.lviv.iot.spring_hibernate_back_end.dto.CityDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.ExerciseDto;

@Component
public class ExerciseDtoAssembler implements RepresentationModelAssembler<Exercise, ExerciseDto> {

    @Override
    public ExerciseDto toModel(Exercise entity) {
        ExerciseDto exerciseDto = ExerciseDto.builder()
            .id(entity.getId())
            .approach(entity.getApproach())
            .complexity(entity.getComplexity())
            .numberOfRepetitions(entity.getNumberOfRepetitions())
            .typeOfMuscleLoadOn(entity.getTypeOfMuscleLoadOn())
            .personalExerciseMachineId(entity.getPersonalExerciseMachine().getId())
            .build();

        Link selfLink = linkTo(methodOn(ExerciseController.class).getExercise(exerciseDto.getId())).withSelfRel();
        exerciseDto.add(selfLink);
        return exerciseDto;
    }

    @Override
    public CollectionModel<ExerciseDto> toCollectionModel(Iterable<? extends Exercise> entities) {
        CollectionModel<ExerciseDto> exerciseDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ExerciseController.class).getAllExercises()).withSelfRel();
        exerciseDtos.add(selfLink);
        return exerciseDtos;
    }
}
