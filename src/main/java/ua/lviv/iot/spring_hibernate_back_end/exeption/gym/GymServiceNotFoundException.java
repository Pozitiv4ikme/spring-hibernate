package ua.lviv.iot.spring_hibernate_back_end.exeption.gym;

public class GymServiceNotFoundException extends RuntimeException {
    public GymServiceNotFoundException(Integer id) {
        super("Gym with id: " + id + " not found");
    }
}
