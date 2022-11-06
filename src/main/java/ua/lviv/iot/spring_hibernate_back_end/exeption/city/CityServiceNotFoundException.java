package ua.lviv.iot.spring_hibernate_back_end.exeption.city;

public class CityServiceNotFoundException extends RuntimeException {
    public CityServiceNotFoundException(Integer id) {
        super("City with id: " + id + " not found");
    }
}
