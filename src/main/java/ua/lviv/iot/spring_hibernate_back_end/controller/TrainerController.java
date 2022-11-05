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
import ua.lviv.iot.spring_hibernate_back_end.dto.TrainerDto;
import ua.lviv.iot.spring_hibernate_back_end.service.CityService;
import ua.lviv.iot.spring_hibernate_back_end.service.TrainerService;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/api/trainers")
public class TrainerController {
    private final TrainerService trainerService;

    @PostMapping(value = "")
    public ResponseEntity<TrainerDto> addTrainer(@RequestBody TrainerDto trainer) {
        TrainerDto newTrainer = trainerService.create(trainer);
        return new ResponseEntity<>(newTrainer, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{trainerId}")
    public ResponseEntity<?> updateTrainer(@RequestBody TrainerDto uTrainer, @PathVariable Integer trainerId) {
        trainerService.update(uTrainer, trainerId);
        return new ResponseEntity<>(uTrainer, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{trainerId}")
    public ResponseEntity<?> deleteTrainer(@PathVariable Integer trainerId) {
        trainerService.delete(trainerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{trainerId}")
    public ResponseEntity<TrainerDto> getTrainer(@PathVariable Integer trainerId) {
        TrainerDto trainerDto = trainerService.findById(trainerId);
        return new ResponseEntity<>(trainerDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<TrainerDto>> getAllTrainers() {
        CollectionModel<TrainerDto> trainers = trainerService.findAll();
        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }
}
