package ua.lviv.iot.spring_hibernate_back_end.controller;

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
import ua.lviv.iot.spring_hibernate_back_end.dto.CityDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.FreeGroupProgramDto;
import ua.lviv.iot.spring_hibernate_back_end.service.CityService;
import ua.lviv.iot.spring_hibernate_back_end.service.FreeGroupProgramService;

@Controller
@AllArgsConstructor
@RequestMapping("/api/freeGroupProgram")
public class FreeGroupProgramController {
    private final FreeGroupProgramService freeGroupProgramService;

    @PostMapping(value = "")
    public ResponseEntity<FreeGroupProgramDto> addFreeGroupProgram(@RequestBody FreeGroupProgramDto freeGroupProgramDto) {
        FreeGroupProgramDto newFreeGroupProgram = freeGroupProgramService.create(freeGroupProgramDto);
        return new ResponseEntity<>(newFreeGroupProgram, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{freeGroupProgramId}")
    public ResponseEntity<?> updateFreeGroupProgram(@RequestBody FreeGroupProgramDto uFreeGroupProgram,
        @PathVariable Integer freeGroupProgramId) {
        freeGroupProgramService.update(uFreeGroupProgram, freeGroupProgramId);
        return new ResponseEntity<>(uFreeGroupProgram, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{freeGroupProgramId}")
    public ResponseEntity<?> deleteFreeGroupProgram(@PathVariable Integer freeGroupProgramId) {
        freeGroupProgramService.delete(freeGroupProgramId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{freeGroupProgramId}")
    public ResponseEntity<FreeGroupProgramDto> getFreeGroupProgram(@PathVariable Integer freeGroupProgramId) {
        FreeGroupProgramDto freeGroupProgramDto = freeGroupProgramService.findById(freeGroupProgramId);
        return new ResponseEntity<>(freeGroupProgramDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<FreeGroupProgramDto>> getAllFreeGroupPrograms() {
        CollectionModel<FreeGroupProgramDto> freeGroupProgramDtos = freeGroupProgramService.findAll();
        return new ResponseEntity<>(freeGroupProgramDtos, HttpStatus.OK);
    }

    @PostMapping(value = "/insert10records")
    public ResponseEntity<?> insert10recordsInTable() {
        freeGroupProgramService.insert10recordsIntoTable();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
