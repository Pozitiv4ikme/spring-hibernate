package ua.lviv.iot.spring_hibernate_back_end.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.spring_hibernate_back_end.dto.CityDto;
import ua.lviv.iot.spring_hibernate_back_end.service.CityService;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/cities")
public class CityController {
    private final CityService cityService;

    @PostMapping(value = "")
    public ResponseEntity<CityDto> addCity(@RequestBody CityDto city) {
        CityDto newCity = cityService.create(city);
        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{cityId}")
    public ResponseEntity<?> updateCity(@RequestBody CityDto uCity, @PathVariable Integer cityId) {
        cityService.update(uCity, cityId);
        return new ResponseEntity<>(uCity, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{cityId}")
    public ResponseEntity<?> deleteCity(@PathVariable Integer cityId) {
        cityService.delete(cityId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{cityId}")
    public ResponseEntity<CityDto> getCity(@PathVariable Integer cityId) {
        CityDto city = cityService.findById(cityId);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<CityDto>> getAllCities() {
        CollectionModel<CityDto> cities = cityService.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
}
