package ua.lviv.iot.spring_hibernate_back_end.domain;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "personal_exercise_machine", schema = "study_iot", catalog = "")
public class PersonalExerciseMachine {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "type", length = 35, nullable = false)
    private String type;
    @Basic
    @Column(name = "client_weight")
    private Integer clientWeight;
    @Basic
    @Column(name = "client_height")
    private Integer clientHeight;
    @Basic
    @Column(name = "client_shoulder_width")
    private Integer clientShoulderWidth;
    @Basic
    @Column(name = "client_leg_length")
    private Integer clientLegLength;
    @Basic
    @Column(name = "client_amount_of_fat_in_body")
    private Integer clientAmountOfFatInBody;
    @Basic
    @Column(name = "client_state_of_health", length = 15, nullable = false)
    private String clientStateOfHealth;
    @OneToMany(mappedBy = "personalExerciseMachine")
    private List<Exercise> exercisesById;

    public List<Exercise> getExercisesById() {
        return exercisesById;
    }

    public void setExercisesById(List<Exercise> exercisesById) {
        this.exercisesById = exercisesById;
    }
}
