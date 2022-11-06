package ua.lviv.iot.spring_hibernate_back_end.dto.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.spring_hibernate_back_end.controller.GenderController;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gender;
import ua.lviv.iot.spring_hibernate_back_end.dto.GenderDto;

@Component
public class GenderDtoAssembler implements RepresentationModelAssembler<Gender, GenderDto> {

    @Override
    public GenderDto toModel(Gender entity) {
        GenderDto genderDto = GenderDto.builder().id(entity.getId()).type(entity.getType()).build();
        Link selfLink = linkTo(methodOn(GenderController.class).getGender(genderDto.getId())).withSelfRel();
        genderDto.add(selfLink);
        return genderDto;
    }

    @Override
    public CollectionModel<GenderDto> toCollectionModel(Iterable<? extends Gender> entities) {
        CollectionModel<GenderDto> genderDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(GenderController.class).getAllGenders()).withSelfRel();
        genderDtos.add(selfLink);
        return genderDtos;
    }
}
