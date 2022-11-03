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
import ua.lviv.iot.spring_hibernate_back_end.service.ClientService;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/clients")
public class ClientController {
    private final ClientService clientService;


    @PostMapping(value = "")
    public ResponseEntity<ClientDto> addClient(@RequestBody ClientDto client) {
        ClientDto newClient = clientService.create(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{clientId}")
    public ResponseEntity<?> updateClient(@RequestBody ClientDto uClient, @PathVariable Integer clientId) {
        clientService.update(uClient, clientId);
        return new ResponseEntity<>(uClient, HttpStatus.OK);
    }

    @GetMapping(value = "/{clientId}")
    public ResponseEntity<ClientDto> getClient(@PathVariable Integer clientId) {
        ClientDto client = clientService.findById(clientId);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Integer clientId) {
        clientService.delete(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ClientDto>> getAllClients() {
        CollectionModel<ClientDto> clients = clientService.findAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping(value = "/gender/{genderId}")
    public ResponseEntity<CollectionModel<ClientDto>> getByGenderId(@PathVariable Integer genderId) {
        CollectionModel<ClientDto> clients = clientService.findClientsByGenderId(genderId);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}
