package ua.lviv.iot.spring_hibernate_back_end.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring_hibernate_back_end.domain.City;
import ua.lviv.iot.spring_hibernate_back_end.exeption.city.CityServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.repository.CityRepository;
import ua.lviv.iot.spring_hibernate_back_end.service.CityService;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public City create(City entity) {
        cityRepository.save(entity);
        return entity;
    }

    @Override
    public City update(City uCity, Integer id) {
        City city = cityRepository.findById(id)
            .orElseThrow(() -> new CityServiceNotFoundException(id));
        //update
        city.setName(uCity.getName());
        cityRepository.save(city);
        return city;
    }

    @Override
    public void delete(Integer id) {
        City city = cityRepository.findById(id)
            .orElseThrow(() -> new CityServiceNotFoundException(id));
        cityRepository.delete(city);
    }

    @Override
    public City findById(Integer id) {
        return cityRepository.findById(id)
            .orElseThrow(() -> new CityServiceNotFoundException(id));
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
