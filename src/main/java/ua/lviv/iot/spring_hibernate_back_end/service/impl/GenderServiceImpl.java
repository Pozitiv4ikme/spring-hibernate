package ua.lviv.iot.spring_hibernate_back_end.service.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring_hibernate_back_end.controller.ClientController;
import ua.lviv.iot.spring_hibernate_back_end.controller.GenderController;
import ua.lviv.iot.spring_hibernate_back_end.domain.City;
import ua.lviv.iot.spring_hibernate_back_end.domain.Client;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gender;
import ua.lviv.iot.spring_hibernate_back_end.dto.CityDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.GenderDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.assembler.GenderDtoAssembler;
import ua.lviv.iot.spring_hibernate_back_end.exeption.city.CityServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.gender.GenderServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.repository.GenderRepository;
import ua.lviv.iot.spring_hibernate_back_end.service.GenderService;

@Service
@AllArgsConstructor
public class GenderServiceImpl implements GenderService {

    private final GenderRepository genderRepository;
    private final GenderDtoAssembler genderDtoAssembler;

    @Override
    public GenderDto create(GenderDto entity) {
        Gender gender = new Gender();
        gender.setType(entity.getType());

        Integer genderId = genderRepository.save(gender).getId();

        Link selfLink = linkTo(methodOn(GenderController.class).getGender(genderId)).withSelfRel();
        entity.add(selfLink);
        return entity;
    }

    @Override
    public GenderDto update(GenderDto uGender, Integer id) {
        Gender gender = genderRepository.findById(id)
            .orElseThrow(() -> new GenderServiceNotFoundException(id));
        //update
        gender.setType(uGender.getType());
        genderRepository.save(gender);
        return uGender;
    }

    @Override
    public void delete(Integer id) {
        Gender gender = genderRepository.findById(id)
            .orElseThrow(() -> new GenderServiceNotFoundException(id));
        genderRepository.delete(gender);
    }

    @Override
    public GenderDto findById(Integer id) {
        Gender gender = genderRepository.findById(id).orElseThrow(() -> new GenderServiceNotFoundException(id));
        return GenderDto.builder()
            .id(gender.getId())
            .type(gender.getType())
            .build();
    }

    @Override
    public CollectionModel<GenderDto> findAll() {
        List<Gender> genders = genderRepository.findAll();
        return genderDtoAssembler.toCollectionModel(genders);
    }
}
