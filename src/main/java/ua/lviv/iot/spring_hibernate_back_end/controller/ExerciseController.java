package ua.lviv.iot.spring_hibernate_back_end.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lviv.iot.spring_hibernate_back_end.dto.CityDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.ExerciseDto;
import ua.lviv.iot.spring_hibernate_back_end.service.CityService;
import ua.lviv.iot.spring_hibernate_back_end.service.ExerciseService;

@Controller
@AllArgsConstructor
@RequestMapping("/api/exercises")
public class ExerciseController {
    private final ExerciseService exerciseService;

    @PostMapping(value = "")
    public ResponseEntity<ExerciseDto> addExercise(@RequestBody ExerciseDto exerciseDto) {
        ExerciseDto newExercise = exerciseService.create(exerciseDto);
        return new ResponseEntity<>(newExercise, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{exerciseId}")
    public ResponseEntity<?> updateExercise(@RequestBody ExerciseDto uExercise, @PathVariable Integer exerciseId) {
        exerciseService.update(uExercise, exerciseId);
        return new ResponseEntity<>(uExercise, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{exerciseId}")
    public ResponseEntity<?> deleteExercise(@PathVariable Integer exerciseId) {
        exerciseService.delete(exerciseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{exerciseId}")
    public ResponseEntity<ExerciseDto> getExercise(@PathVariable Integer exerciseId) {
        ExerciseDto exerciseDto = exerciseService.findById(exerciseId);
        return new ResponseEntity<>(exerciseDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ExerciseDto>> getAllExercises() {
        CollectionModel<ExerciseDto> exerciseDtos = exerciseService.findAll();
        return new ResponseEntity<>(exerciseDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/complexity/{complexityNum}/typeOfMuscleLoadOn/{typeOfMuscleLoadOnVal}")
    public ResponseEntity<CollectionModel<ExerciseDto>> getAllExerciseByComplexityAndTypeOfMuscleLoadOn(@PathVariable Integer complexityNum, @PathVariable String typeOfMuscleLoadOnVal) {
        CollectionModel<ExerciseDto> exerciseDtos =
            exerciseService.findByComplexityAndTypeOfMuscleLoadOn(complexityNum, typeOfMuscleLoadOnVal);
        return new ResponseEntity<>(exerciseDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/complexityAvg")
    public ResponseEntity<?> findAvgOfComplexity() {
         return new ResponseEntity<>("Average value of complexity is: " + exerciseService.findAvgOfComplexity(),
             HttpStatus.OK);
    }
}
