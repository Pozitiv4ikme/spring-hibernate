package ua.lviv.iot.spring_hibernate_back_end.exeption.free.group.program;

public class FreeGroupProgramServiceNotFoundException extends RuntimeException {
    public FreeGroupProgramServiceNotFoundException(Integer id) {
        super("Free group program with id: " + id + " not found");
    }
}
