package ua.lviv.iot.spring_hibernate_back_end.exeption.personal.training;

public class PersonalTrainingServiceNotFoundException extends RuntimeException {
    public PersonalTrainingServiceNotFoundException(Integer id) {
        super("Personal training with id: " + id + " not found");
    }
}
