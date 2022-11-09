package ua.lviv.iot.spring_hibernate_back_end.service.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring_hibernate_back_end.controller.FreeGroupProgramController;
import ua.lviv.iot.spring_hibernate_back_end.domain.FreeGroupProgram;
import ua.lviv.iot.spring_hibernate_back_end.dto.FreeGroupProgramDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.assembler.FreeGroupProgramDtoAssembler;
import ua.lviv.iot.spring_hibernate_back_end.exeption.free.group.program.FreeGroupProgramServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.repository.FreeGroupProgramRepository;
import ua.lviv.iot.spring_hibernate_back_end.service.FreeGroupProgramService;

@Service
public class FreeGroupProgramServiceImpl implements FreeGroupProgramService {

    private final FreeGroupProgramRepository freeGroupProgramRepository;
    private final FreeGroupProgramDtoAssembler freeGroupProgramDtoAssembler;

    public FreeGroupProgramServiceImpl(FreeGroupProgramRepository freeGroupProgramRepository,
        FreeGroupProgramDtoAssembler freeGroupProgramDtoAssembler) {
        this.freeGroupProgramDtoAssembler = freeGroupProgramDtoAssembler;
        this.freeGroupProgramRepository = freeGroupProgramRepository;
    }

    @Override
    public void insert10recordsIntoTable() {
        freeGroupProgramRepository.insert10records();
    }

    @Override
    public FreeGroupProgramDto create(FreeGroupProgramDto entity) {
        FreeGroupProgram freeGroupProgram = new FreeGroupProgram();
        freeGroupProgram.setDay(entity.getDay());
        freeGroupProgram.setExercise(entity.getExercise());

        Integer freeGroupProgramId = freeGroupProgramRepository.save(freeGroupProgram).getId();
        entity.setId(freeGroupProgramId);

        Link selfLink = linkTo(methodOn(FreeGroupProgramController.class).getFreeGroupProgram(freeGroupProgramId)).withSelfRel();
        entity.add(selfLink);
        return entity;
    }

    @Override
    public FreeGroupProgramDto update(FreeGroupProgramDto uFreeGroupProgram, Integer id) {
        FreeGroupProgram freeGroupProgram = freeGroupProgramRepository.findById(id)
            .orElseThrow(() -> new FreeGroupProgramServiceNotFoundException(id));
        //update
        freeGroupProgram.setDay(uFreeGroupProgram.getDay());
        freeGroupProgram.setExercise(uFreeGroupProgram.getExercise());
        return uFreeGroupProgram;
    }

    @Override
    public void delete(Integer id) {
        FreeGroupProgram freeGroupProgram = freeGroupProgramRepository.findById(id)
            .orElseThrow(() -> new FreeGroupProgramServiceNotFoundException(id));
        freeGroupProgramRepository.delete(freeGroupProgram);
    }

    @Override
    public FreeGroupProgramDto findById(Integer id) {
        FreeGroupProgram freeGroupProgram =
            freeGroupProgramRepository.findById(id).orElseThrow(() -> new FreeGroupProgramServiceNotFoundException(id));
        return freeGroupProgramDtoAssembler.toModel(freeGroupProgram);
    }

    @Override
    public CollectionModel<FreeGroupProgramDto> findAll() {
        List<FreeGroupProgram> freeGroupPrograms =  freeGroupProgramRepository.findAll();
        return freeGroupProgramDtoAssembler.toCollectionModel(freeGroupPrograms);
    }
}
