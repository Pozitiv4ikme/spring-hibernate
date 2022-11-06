package ua.lviv.iot.spring_hibernate_back_end.exeption.exercise;

public class ExerciseServiceNotFoundException extends RuntimeException {
    public ExerciseServiceNotFoundException(Integer id) {
        super("Exercise with id: " + id + " not found");
    }
}
