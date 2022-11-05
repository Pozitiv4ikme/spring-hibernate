package ua.lviv.iot.spring_hibernate_back_end.exeption.trainer;

public class TrainerServiceNotFoundException extends RuntimeException {
    public TrainerServiceNotFoundException(Integer id) {
        super("TrainerController with id: " + id + " not found");
    }
}
