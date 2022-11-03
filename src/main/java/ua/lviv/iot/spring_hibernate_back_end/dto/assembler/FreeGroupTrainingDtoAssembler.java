package ua.lviv.iot.spring_hibernate_back_end.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.spring_hibernate_back_end.domain.FreeGroupTraining;
import ua.lviv.iot.spring_hibernate_back_end.dto.FreeGroupTrainingDto;

@Component
public class FreeGroupTrainingDtoAssembler implements RepresentationModelAssembler<FreeGroupTraining, FreeGroupTrainingDto> {

    @Override
    public FreeGroupTrainingDto toModel(FreeGroupTraining entity) {
        return null;
    }

    @Override
    public CollectionModel<FreeGroupTrainingDto> toCollectionModel(Iterable<? extends FreeGroupTraining> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
