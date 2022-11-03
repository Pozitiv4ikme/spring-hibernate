package ua.lviv.iot.spring_hibernate_back_end.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lviv.iot.spring_hibernate_back_end.domain.City;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gender;
import ua.lviv.iot.spring_hibernate_back_end.dto.CityDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.GenderDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.assembler.CityDtoAssembler;
import ua.lviv.iot.spring_hibernate_back_end.dto.assembler.GenderDtoAssembler;
import ua.lviv.iot.spring_hibernate_back_end.service.CityService;
import ua.lviv.iot.spring_hibernate_back_end.service.GenderService;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/api/genders")
public class GenderController {
    private final GenderService genderService;

    @PostMapping(value = "")
    public ResponseEntity<GenderDto> addGender(@RequestBody GenderDto gender) {
        GenderDto newGender = genderService.create(gender);
        return new ResponseEntity<>(newGender, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{genderId}")
    public ResponseEntity<?> updateGender(@RequestBody GenderDto uGender, @PathVariable Integer genderId) {
        genderService.update(uGender, genderId);
        return new ResponseEntity<>(uGender, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{genderId}")
    public ResponseEntity<?> deleteGender(@PathVariable Integer genderId) {
        genderService.delete(genderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{genderId}")
    public ResponseEntity<GenderDto> getGender(@PathVariable Integer genderId) {
        GenderDto gender = genderService.findById(genderId);
        return new ResponseEntity<>(gender, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<GenderDto>> getAllGenders() {
        CollectionModel<GenderDto> genders = genderService.findAll();
        return new ResponseEntity<>(genders, HttpStatus.OK);
    }
}
