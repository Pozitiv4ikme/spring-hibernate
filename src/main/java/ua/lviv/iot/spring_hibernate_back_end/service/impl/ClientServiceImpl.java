package ua.lviv.iot.spring_hibernate_back_end.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring_hibernate_back_end.domain.Client;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gender;
import ua.lviv.iot.spring_hibernate_back_end.exeption.client.ClientServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.repository.ClientRepository;
import ua.lviv.iot.spring_hibernate_back_end.service.ClientService;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> findByGender(Gender gender) {

        return null;
    }

    @Override
    public Client findByNameIgnoreCase(String name) {
        return null;
    }

    @Override
    public Client create(Client entity) {
        clientRepository.save(entity);
        return entity;
    }

    @Override
    public Client update(Client uClient, Integer id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new ClientServiceNotFoundException(id));
        //update
        client.setName(uClient.getName());
        client.setSurname(uClient.getSurname());
        client.setPhone(uClient.getPhone());
        client.setBirthday(uClient.getBirthday());
        client.setGender(uClient.getGender());
        clientRepository.save(client);
        return client;
    }

    @Override
    public void delete(Integer id) {
        Client client = clientRepository.findById(id)
            .orElseThrow(() -> new ClientServiceNotFoundException(id));
        clientRepository.delete(client);
    }

    @Override
    public Client findById(Integer id) {
        return clientRepository.findById(id)
            .orElseThrow(() -> new ClientServiceNotFoundException(id));
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
