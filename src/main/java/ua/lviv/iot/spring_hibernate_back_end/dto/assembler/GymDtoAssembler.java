package ua.lviv.iot.spring_hibernate_back_end.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.spring_hibernate_back_end.domain.Gym;
import ua.lviv.iot.spring_hibernate_back_end.dto.GymDto;

@Component
public class GymDtoAssembler implements RepresentationModelAssembler<Gym, GymDto> {

    @Override
    public GymDto toModel(Gym entity) {
        return null;
    }

    @Override
    public CollectionModel<GymDto> toCollectionModel(Iterable<? extends Gym> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
