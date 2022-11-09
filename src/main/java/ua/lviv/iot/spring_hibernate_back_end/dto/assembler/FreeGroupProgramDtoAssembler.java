package ua.lviv.iot.spring_hibernate_back_end.dto.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.spring_hibernate_back_end.controller.CityController;
import ua.lviv.iot.spring_hibernate_back_end.controller.FreeGroupProgramController;
import ua.lviv.iot.spring_hibernate_back_end.domain.City;
import ua.lviv.iot.spring_hibernate_back_end.domain.FreeGroupProgram;
import ua.lviv.iot.spring_hibernate_back_end.dto.CityDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.FreeGroupProgramDto;

@Component
public class FreeGroupProgramDtoAssembler implements RepresentationModelAssembler<FreeGroupProgram, FreeGroupProgramDto> {

    @Override
    public FreeGroupProgramDto toModel(FreeGroupProgram entity) {
        FreeGroupProgramDto freeGroupProgramDto = FreeGroupProgramDto.builder()
            .id(entity.getId())
            .day(entity.getDay())
            .exercise(entity.getExercise())
            .build();

        Link selfLink =
            linkTo(methodOn(FreeGroupProgramController.class).getFreeGroupProgram(entity.getId())).withSelfRel();
        freeGroupProgramDto.add(selfLink);
        return freeGroupProgramDto;
    }

    @Override
    public CollectionModel<FreeGroupProgramDto> toCollectionModel(Iterable<? extends FreeGroupProgram> entities) {
        CollectionModel<FreeGroupProgramDto> freeGroupProgramDtos =
            RepresentationModelAssembler.super.toCollectionModel(entities);

        Link selfLink = linkTo(methodOn(FreeGroupProgramController.class).getAllFreeGroupPrograms()).withSelfRel();
        freeGroupProgramDtos.add(selfLink);
        return freeGroupProgramDtos;
    }
}
