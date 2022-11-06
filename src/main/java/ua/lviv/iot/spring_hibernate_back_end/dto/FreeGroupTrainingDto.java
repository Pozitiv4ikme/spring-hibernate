package ua.lviv.iot.spring_hibernate_back_end.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@Relation(itemRelation = "free_group_training", collectionRelation = "free_group_trainings")
public class FreeGroupTrainingDto extends RepresentationModel<FreeGroupTrainingDto> {
    private final Integer id;
    private final String trainer;
    private final String freeGroupProgramByFreeGroupProgramId;
}
