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
import ua.lviv.iot.spring_hibernate_back_end.dto.ClientDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.GymDto;
import ua.lviv.iot.spring_hibernate_back_end.service.GymService;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/gyms")
public class GymController {
    private final GymService gymService;

    @PostMapping(value = "")
    public ResponseEntity<GymDto> addGym(@RequestBody GymDto gymDto) {
        GymDto newGym = gymService.create(gymDto);
        return new ResponseEntity<>(newGym, HttpStatus.CREATED);
    }

    @PostMapping(value = "/insertWithProcedure")
    public ResponseEntity<GymDto> insertWithProcedure(@RequestBody GymDto gymDto) {
        GymDto newGym = gymService.insertWithProcedure(gymDto);
        return new ResponseEntity<>(newGym, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{gymId}")
    public ResponseEntity<?> updateGym(@RequestBody GymDto uGym, @PathVariable Integer gymId) {
        gymService.update(uGym, gymId);
        return new ResponseEntity<>(uGym, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{gymId}")
    public ResponseEntity<?> deleteGym(@PathVariable Integer gymId) {
        gymService.delete(gymId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{gymId}")
    public ResponseEntity<GymDto> getGym(@PathVariable Integer gymId) {
        GymDto gymDto = gymService.findById(gymId);
        return new ResponseEntity<>(gymDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<GymDto>> getAllGyms() {
        CollectionModel<GymDto> gymsDtos = gymService.findAll();
        return new ResponseEntity<>(gymsDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/city/{cityId}")
    public ResponseEntity<CollectionModel<GymDto>> getByCityId(@PathVariable Integer cityId) {
        CollectionModel<GymDto> gymsDtos = gymService.findByCityId(cityId);
        return new ResponseEntity<>(gymsDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{gymId}/clients")
    public ResponseEntity<CollectionModel<ClientDto>> getClients(@PathVariable Integer gymId) {
        CollectionModel<ClientDto> clientsDtos = gymService.findAllClientsById(gymId);
        return new ResponseEntity<>(clientsDtos, HttpStatus.OK);
    }

    @PutMapping(value = "/{gymId}/clients/{clientId}")
    public ResponseEntity<?> addClientToGym(@PathVariable Integer gymId, @PathVariable Integer clientId) {
        gymService.addClientToGym(gymId, clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{gymId}/clients/{clientId}/insertIntoClientGym")
    public ResponseEntity<?> insertIntoClientGym(@PathVariable Integer gymId, @PathVariable Integer clientId) {
        try {
            gymService.insertClientToGym(gymId, clientId);
        } catch (Exception e) {
            return new ResponseEntity<>("Error caused by: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
