package ua.lviv.iot.spring_hibernate_back_end.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@Relation(itemRelation = "exercise", collectionRelation = "exercises")
public class ExerciseDto extends RepresentationModel<ExerciseDto> {
    @Setter
    private Integer id;
    private final Integer numberOfRepetitions;
    private final Integer approach;
    private final Integer complexity;
    private final String typeOfMuscleLoadOn;
    private final Integer personalExerciseMachineId;
}
