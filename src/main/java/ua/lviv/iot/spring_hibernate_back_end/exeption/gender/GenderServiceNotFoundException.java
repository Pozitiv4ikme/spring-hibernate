package ua.lviv.iot.spring_hibernate_back_end.exeption.gender;

public class GenderServiceNotFoundException extends RuntimeException {
    public GenderServiceNotFoundException(Integer id) {
        super("Gender with id: " + id + " not found");
    }
}
