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
import ua.lviv.iot.spring_hibernate_back_end.dto.PersonalExerciseMachineDto;
import ua.lviv.iot.spring_hibernate_back_end.service.CityService;
import ua.lviv.iot.spring_hibernate_back_end.service.PersonalExerciseMachineService;

@Controller
@AllArgsConstructor
@RequestMapping("/api/personalExerciseMachines")
public class PersonalExerciseMachineController {
    private final PersonalExerciseMachineService personalExerciseMachineService;

    @PostMapping(value = "")
    public ResponseEntity<PersonalExerciseMachineDto> addCity(@RequestBody PersonalExerciseMachineDto personalExerciseMachineDto) {
        PersonalExerciseMachineDto newPersonalExerciseMachine = personalExerciseMachineService.create(personalExerciseMachineDto);
        return new ResponseEntity<>(newPersonalExerciseMachine, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{personalExerciseMachineId}")
    public ResponseEntity<?> updatePersonalExerciseMachine(@RequestBody PersonalExerciseMachineDto uPersonalExerciseMachine,
        @PathVariable Integer personalExerciseMachineId) {
        personalExerciseMachineService.update(uPersonalExerciseMachine, personalExerciseMachineId);
        return new ResponseEntity<>(uPersonalExerciseMachine, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{personalExerciseMachineId}")
    public ResponseEntity<?> deletePersonalExerciseMachine(@PathVariable Integer personalExerciseMachineId) {
        personalExerciseMachineService.delete(personalExerciseMachineId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{personalExerciseMachineId}")
    public ResponseEntity<PersonalExerciseMachineDto> getPersonalExerciseMachine(@PathVariable Integer personalExerciseMachineId) {
        PersonalExerciseMachineDto personalExerciseMachineDto = personalExerciseMachineService.findById(personalExerciseMachineId);
        return new ResponseEntity<>(personalExerciseMachineDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<PersonalExerciseMachineDto>> getAllPersonalExerciseMachines() {
        CollectionModel<PersonalExerciseMachineDto> personalExerciseMachineDtos = personalExerciseMachineService.findAll();
        return new ResponseEntity<>(personalExerciseMachineDtos, HttpStatus.OK);
    }
}
