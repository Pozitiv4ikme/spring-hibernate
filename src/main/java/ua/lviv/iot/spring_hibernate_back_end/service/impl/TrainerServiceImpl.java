package ua.lviv.iot.spring_hibernate_back_end.service.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring_hibernate_back_end.controller.TrainerController;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gym;
import ua.lviv.iot.spring_hibernate_back_end.domain.Trainer;
import ua.lviv.iot.spring_hibernate_back_end.dto.TrainerDto;
import ua.lviv.iot.spring_hibernate_back_end.dto.assembler.TrainerDtoAssembler;
import ua.lviv.iot.spring_hibernate_back_end.exeption.gym.GymServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.exeption.trainer.TrainerServiceNotFoundException;
import ua.lviv.iot.spring_hibernate_back_end.repository.GymRepository;
import ua.lviv.iot.spring_hibernate_back_end.repository.TrainerRepository;
import ua.lviv.iot.spring_hibernate_back_end.service.TrainerService;

@Service
@AllArgsConstructor
public class TrainerServiceImpl implements TrainerService {

    private final GymRepository gymRepository;
    private final TrainerRepository trainerRepository;
    private final TrainerDtoAssembler trainerDtoAssembler;

    @Override
    public TrainerDto create(TrainerDto entity) {
        Trainer trainer = new Trainer();
        trainer.setName(entity.getName());
        trainer.setSurname(entity.getSurname());
        trainer.setPhone(entity.getPhone());

        Gym gym =
            gymRepository.findById(entity.getGymId()).orElseThrow(() -> new GymServiceNotFoundException(entity.getGymId()));
        trainer.setGym(gym);

        Integer trainerId = trainerRepository.save(trainer).getId();
        entity.setId(trainerId);

        Link selfLink = linkTo(methodOn(TrainerController.class).getTrainer(trainerId)).withSelfRel();
        entity.add(selfLink);
        return entity;
    }

    @Override
    public TrainerDto update(TrainerDto uTrainer, Integer id) {
        Trainer trainer = trainerRepository.findById(id)
            .orElseThrow(() -> new TrainerServiceNotFoundException(id));
        //update
        trainer.setId(id);
        trainer.setName(uTrainer.getName());
        trainer.setSurname(uTrainer.getSurname());
        trainer.setPhone(uTrainer.getPhone());

        Gym gym = gymRepository.findById(uTrainer.getGymId()).orElseThrow(() -> new GymServiceNotFoundException(id));
        trainer.setGym(gym);
        return uTrainer;
    }

    @Override
    public void delete(Integer id) {
        Trainer trainer = trainerRepository.findById(id).orElseThrow(() -> new TrainerServiceNotFoundException(id));
        trainerRepository.delete(trainer);
    }

    @Override
    public TrainerDto findById(Integer id) {
        Trainer trainer = trainerRepository.findById(id).orElseThrow(() -> new TrainerServiceNotFoundException(id));
        return TrainerDto.builder()
            .id(trainer.getId())
            .name(trainer.getName())
            .surname(trainer.getSurname())
            .phone(trainer.getPhone())
            .build();
    }

    @Override
    public CollectionModel<TrainerDto> findAll() {
        List<Trainer> trainers = trainerRepository.findAll();
        return trainerDtoAssembler.toCollectionModel(trainers);
    }
}
