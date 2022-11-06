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
@Relation(itemRelation = "personal_exercise_machine", collectionRelation = "personal_exercise_machines")
public class PersonalExerciseMachineDto extends RepresentationModel<PersonalExerciseMachineDto> {
    private final Integer id;
    private final String type;
    private final Integer clientWeight;
    private final Integer clientHeight;
    private final Integer clientShoulderWidth;
    private final Integer clientLegLength;
    private final Integer clientAmountOfFatInBody;
    private final String clientStateOfHealth;
}
