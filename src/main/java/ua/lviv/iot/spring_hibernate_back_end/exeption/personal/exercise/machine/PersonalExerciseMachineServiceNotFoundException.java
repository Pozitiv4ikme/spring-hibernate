package ua.lviv.iot.spring_hibernate_back_end.exeption.personal.exercise.machine;

public class PersonalExerciseMachineServiceNotFoundException extends RuntimeException {
    public PersonalExerciseMachineServiceNotFoundException(Integer id) {
        super("Personal exercise machine with id: " + id + " not found");
    }
}
