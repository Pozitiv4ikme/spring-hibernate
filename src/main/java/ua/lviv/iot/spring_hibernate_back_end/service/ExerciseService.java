package ua.lviv.iot.spring_hibernate_back_end.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.hateoas.CollectionModel;
import ua.lviv.iot.spring_hibernate_back_end.dto.ExerciseDto;

public interface ExerciseService extends GeneralService<ExerciseDto, Integer>{

    CollectionModel<ExerciseDto> findByComplexityAndTypeOfMuscleLoadOn(Integer complexity, String typeOfMuscleLoadOn);
    Integer findAvgOfComplexity();
}

