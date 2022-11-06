package ua.lviv.iot.spring_hibernate_back_end.controller;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.lviv.iot.spring_hibernate_back_end.exeption.city.CityServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.client.ClientServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.exercise.ExerciseServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.free.group.program.FreeGroupProgramServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.free.group.training.FreeGroupTrainingServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.gender.GenderServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.gym.GymServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.personal.exercise.machine.PersonalExerciseMachineServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.personal.training.PersonalTrainingServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.trainer.TrainerServiceNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(CityServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> cityNotFoundHandler(CityServiceNotFoundException ex) {
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }

    @ResponseBody
    @ExceptionHandler(ClientServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> clientNotFoundHandler(ClientServiceNotFoundException ex) {
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }

    @ResponseBody
    @ExceptionHandler(ExerciseServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> exerciseNotFoundHandler(ExerciseServiceNotFoundException ex) {
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }

    @ResponseBody
    @ExceptionHandler(FreeGroupProgramServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> freeGroupProgramHandler(FreeGroupProgramServiceNotFoundException ex) {
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }

    @ResponseBody
    @ExceptionHandler(FreeGroupTrainingServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> freeGroupTrainingHandler(FreeGroupTrainingServiceNotFoundException ex) {
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }

    @ResponseBody
    @ExceptionHandler(GenderServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> genderHandler(GenderServiceNotFoundException ex) {
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }

    @ResponseBody
    @ExceptionHandler(GymServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> gymHandler(GymServiceNotFoundException ex) {
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }

    @ResponseBody
    @ExceptionHandler(PersonalExerciseMachineServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> personalExerciseMachineHandler(PersonalExerciseMachineServiceNotFoundException ex) {
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }

    @ResponseBody
    @ExceptionHandler(PersonalTrainingServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> personalTrainingHandler(PersonalTrainingServiceNotFoundException ex) {
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }

    @ResponseBody
    @ExceptionHandler(TrainerServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> trainerHandler(TrainerServiceNotFoundException ex) {
        return Map.of("message", ex.getMessage(), "type", ex.getClass().getSimpleName());
    }
}
