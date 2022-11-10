package ua.lviv.iot.spring_hibernate_back_end.service.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring_hibernate_back_end.controller.ExerciseController;
import ua.lviv.iot.spring_hibernate_back_end.domain.Exercise;
import ua.lviv.iot.spring_hibernate_back_end.domain.PersonalExerciseMachine;
import ua.lviv.iot.spring_hibernate_back_end.dto.ExerciseDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.assembler.ExerciseDtoAssembler;
import ua.lviv.iot.spring_hibernate_back_end.exeption.exercise.ExerciseServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.personal.exercise.machine.PersonalExerciseMachineServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.repository.ExerciseRepository;
import ua.lviv.iot.spring_hibernate_back_end.repository.PersonalExerciseMachineRepository;
import ua.lviv.iot.spring_hibernate_back_end.service.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseDtoAssembler exerciseDtoAssembler;
    private final PersonalExerciseMachineRepository personalExerciseMachineRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ExerciseDtoAssembler exerciseDtoAssembler, PersonalExerciseMachineRepository personalExerciseMachineRepository) {
        this.exerciseDtoAssembler = exerciseDtoAssembler;
        this.exerciseRepository = exerciseRepository;
        this.personalExerciseMachineRepository = personalExerciseMachineRepository;
    }

    @Override
    public CollectionModel<ExerciseDto> findByComplexityAndTypeOfMuscleLoadOn(Integer complexity,
        String typeOfMuscleLoadOn) {
        List<Exercise> exercises = exerciseRepository.findByComplexityAndTypeOfMuscleLoadOn(complexity,
            typeOfMuscleLoadOn);
        return exerciseDtoAssembler.toCollectionModel(exercises);
    }

    @Override
    public Integer findAvgOfComplexity() {
        return exerciseRepository.exerciseComplexityAvg();
    }

    @Override
    public ExerciseDto create(ExerciseDto entity) {
        Exercise exercise = new Exercise();
        exercise.setApproach(entity.getApproach());
        exercise.setComplexity(entity.getComplexity());
        exercise.setNumberOfRepetitions(entity.getNumberOfRepetitions());
        exercise.setTypeOfMuscleLoadOn(entity.getTypeOfMuscleLoadOn());

        PersonalExerciseMachine personalExerciseMachine =
            personalExerciseMachineRepository.findById(entity.getPersonalExerciseMachineId()).orElseThrow(() -> new PersonalExerciseMachineServiceNotFoundException(entity.getPersonalExerciseMachineId()));
        exercise.setPersonalExerciseMachine(personalExerciseMachine);

        Integer id = exerciseRepository.save(exercise).getId();
        entity.setId(id);

        Link selfLink = linkTo(methodOn(ExerciseController.class).getExercise(id)).withSelfRel();
        entity.add(selfLink);
        return entity;
    }

    @Override
    public ExerciseDto update(ExerciseDto uExercise, Integer id) {
        Exercise exercise = exerciseRepository.findById(id)
            .orElseThrow(() -> new ExerciseServiceNotFoundException(id));
        //update
        exercise.setApproach(uExercise.getApproach());
        exercise.setComplexity(uExercise.getComplexity());
        exercise.setNumberOfRepetitions(uExercise.getNumberOfRepetitions());
        exercise.setTypeOfMuscleLoadOn(uExercise.getTypeOfMuscleLoadOn());

        PersonalExerciseMachine personalExerciseMachine =
            personalExerciseMachineRepository.findById(uExercise.getPersonalExerciseMachineId()).orElseThrow(() -> new PersonalExerciseMachineServiceNotFoundException(uExercise.getPersonalExerciseMachineId()));
        exercise.setPersonalExerciseMachine(personalExerciseMachine);
        return uExercise;
    }

    @Override
    public void delete(Integer id) {
        Exercise exercise = exerciseRepository.findById(id)
            .orElseThrow(() -> new ExerciseServiceNotFoundException(id));
        exerciseRepository.delete(exercise);
    }

    @Override
    public ExerciseDto findById(Integer id) {
        Exercise exercise = exerciseRepository.findById(id).orElseThrow(() -> new ExerciseServiceNotFoundException(id));
        return exerciseDtoAssembler.toModel(exercise);
    }

    @Override
    public CollectionModel<ExerciseDto> findAll() {
        List<Exercise> exercises =  exerciseRepository.findAll();
        return exerciseDtoAssembler.toCollectionModel(exercises);
    }
}
