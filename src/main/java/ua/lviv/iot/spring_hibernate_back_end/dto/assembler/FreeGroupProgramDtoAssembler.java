package ua.lviv.iot.spring_hibernate_back_end.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.spring_hibernate_back_end.domain.FreeGroupProgram;
import ua.lviv.iot.spring_hibernate_back_end.dto.FreeGroupProgramDto;

@Component
public class FreeGroupProgramDtoAssembler implements RepresentationModelAssembler<FreeGroupProgram, FreeGroupProgramDto> {

    @Override
    public FreeGroupProgramDto toModel(FreeGroupProgram entity) {
        return null;
    }

    @Override
    public CollectionModel<FreeGroupProgramDto> toCollectionModel(Iterable<? extends FreeGroupProgram> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
