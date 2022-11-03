package ua.lviv.iot.spring_hibernate_back_end.service.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring_hibernate_back_end.controller.CityController;
import ua.lviv.iot.spring_hibernate_back_end.controller.ClientController;
import ua.lviv.iot.spring_hibernate_back_end.domain.City;
import ua.lviv.iot.spring_hibernate_back_end.dto.CityDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.assembler.CityDtoAssembler;
import ua.lviv.iot.spring_hibernate_back_end.exeption.city.CityServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.repository.CityRepository;
import ua.lviv.iot.spring_hibernate_back_end.service.CityService;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityDtoAssembler cityDtoAssembler;

    @Override
    public CityDto create(CityDto entity) {
        City city = new City();
        city.setName(entity.getName());

        Integer cityId = cityRepository.save(city).getId();

        Link selfLink = linkTo(methodOn(CityController.class).getCity(cityId)).withSelfRel();
        entity.add(selfLink);
        return entity;
    }

    @Override
    public CityDto update(CityDto uCity, Integer id) {
        City city = cityRepository.findById(id)
            .orElseThrow(() -> new CityServiceNotFoundException(id));
        //update
        city.setName(uCity.getName());
        return uCity;
    }

    @Override
    public void delete(Integer id) {
        City city = cityRepository.findById(id)
            .orElseThrow(() -> new CityServiceNotFoundException(id));
        cityRepository.delete(city);
    }

    @Override
    public CityDto findById(Integer id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new CityServiceNotFoundException(id));
        return CityDto.builder()
            .id(city.getId())
            .name(city.getName())
            .build();
    }

    @Override
    public CollectionModel<CityDto> findAll() {
        List<City> cities =  cityRepository.findAll();
        return cityDtoAssembler.toCollectionModel(cities);
    }
}
