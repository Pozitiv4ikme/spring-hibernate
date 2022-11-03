package ua.lviv.iot.spring_hibernate_back_end.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.spring_hibernate_back_end.domain.Trainer;
import ua.lviv.iot.spring_hibernate_back_end.dto.TrainerDto;

@Component
public class TrainerDtoAssembler implements RepresentationModelAssembler<Trainer, TrainerDto> {

    @Override
    public TrainerDto toModel(Trainer entity) {
        return null;
    }

    @Override
    public CollectionModel<TrainerDto> toCollectionModel(Iterable<? extends Trainer> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
