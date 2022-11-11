package ua.lviv.iot.spring_hibernate_back_end.service.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring_hibernate_back_end.controller.PersonalExerciseMachineController;
import ua.lviv.iot.spring_hibernate_back_end.domain.PersonalExerciseMachine;
import ua.lviv.iot.spring_hibernate_back_end.dto.PersonalExerciseMachineDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.assembler.PersonalExerciseMachineDtoAssembler;
import ua.lviv.iot.spring_hibernate_back_end.exeption.personal.exercise.machine.PersonalExerciseMachineServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.repository.PersonalExerciseMachineRepository;
import ua.lviv.iot.spring_hibernate_back_end.service.PersonalExerciseMachineService;

@Service
public class PersonalExerciseMachineServiceImpl implements PersonalExerciseMachineService {

    private final PersonalExerciseMachineRepository personalExerciseMachineRepository;
    private final PersonalExerciseMachineDtoAssembler personalExerciseMachineDtoAssembler;

    public PersonalExerciseMachineServiceImpl(PersonalExerciseMachineRepository personalExerciseMachineRepository,
        PersonalExerciseMachineDtoAssembler personalExerciseMachineDtoAssembler) {
        this.personalExerciseMachineRepository = personalExerciseMachineRepository;
        this.personalExerciseMachineDtoAssembler = personalExerciseMachineDtoAssembler;
    }

    @Override
    public PersonalExerciseMachineDto create(PersonalExerciseMachineDto entity) {
        PersonalExerciseMachine personalExerciseMachine = new PersonalExerciseMachine();
        personalExerciseMachine.setClientAmountOfFatInBody(entity.getClientAmountOfFatInBody());
        personalExerciseMachine.setClientHeight(entity.getClientHeight());
        personalExerciseMachine.setClientLegLength(entity.getClientLegLength());
        personalExerciseMachine.setClientShoulderWidth(entity.getClientShoulderWidth());
        personalExerciseMachine.setClientStateOfHealth(entity.getClientStateOfHealth());
        personalExerciseMachine.setClientWeight(entity.getClientWeight());
        personalExerciseMachine.setType(entity.getType());

        Integer id = personalExerciseMachineRepository.save(personalExerciseMachine).getId();
        entity.setId(id);

        Link selfLink =
            linkTo(methodOn(PersonalExerciseMachineController.class).getPersonalExerciseMachine(id)).withSelfRel();
        entity.add(selfLink);
        return entity;
    }

    @Override
    public PersonalExerciseMachineDto update(PersonalExerciseMachineDto uPersonalExerciseMachine, Integer id) {
        PersonalExerciseMachine personalExerciseMachine = personalExerciseMachineRepository.findById(id)
            .orElseThrow(() -> new PersonalExerciseMachineServiceNotFoundException(id));
        //update
        personalExerciseMachine.setClientAmountOfFatInBody(uPersonalExerciseMachine.getClientAmountOfFatInBody());
        personalExerciseMachine.setClientHeight(uPersonalExerciseMachine.getClientHeight());
        personalExerciseMachine.setClientLegLength(uPersonalExerciseMachine.getClientLegLength());
        personalExerciseMachine.setClientShoulderWidth(uPersonalExerciseMachine.getClientShoulderWidth());
        personalExerciseMachine.setClientStateOfHealth(uPersonalExerciseMachine.getClientStateOfHealth());
        personalExerciseMachine.setClientWeight(uPersonalExerciseMachine.getClientWeight());
        personalExerciseMachine.setType(uPersonalExerciseMachine.getType());

        return uPersonalExerciseMachine;
    }

    @Override
    public void delete(Integer id) {
        PersonalExerciseMachine personalExerciseMachine =
            personalExerciseMachineRepository.findById(id).orElseThrow(() -> new PersonalExerciseMachineServiceNotFoundException(id));
        personalExerciseMachineRepository.delete(personalExerciseMachine);
    }

    @Override
    public PersonalExerciseMachineDto findById(Integer id) {
        PersonalExerciseMachine personalExerciseMachine =
            personalExerciseMachineRepository.findById(id).orElseThrow(() -> new PersonalExerciseMachineServiceNotFoundException(id));
        return personalExerciseMachineDtoAssembler.toModel(personalExerciseMachine);
    }

    @Override
    public CollectionModel<PersonalExerciseMachineDto> findAll() {
        List<PersonalExerciseMachine> personalExerciseMachines = personalExerciseMachineRepository.findAll();
        return personalExerciseMachineDtoAssembler.toCollectionModel(personalExerciseMachines);
    }
}
