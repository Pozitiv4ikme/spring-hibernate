package ua.lviv.iot.spring_hibernate_back_end.exeption.client;

public class ClientServiceNotFoundException extends RuntimeException {
    public ClientServiceNotFoundException(Integer id) {
        super("Client with id: " + id + " not found");
    }
}
