package ua.lviv.iot.spring_hibernate_back_end.exeption.free.group.training;

public class FreeGroupTrainingServiceNotFoundException extends RuntimeException{
    public FreeGroupTrainingServiceNotFoundException(Integer id) {
        super("Free group training with id: " + id + " not found");
    }
}
