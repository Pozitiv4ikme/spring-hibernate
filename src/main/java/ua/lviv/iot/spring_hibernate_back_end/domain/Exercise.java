package ua.lviv.iot.spring_hibernate_back_end.domain;

import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "exercise", schema = "study_iot", catalog = "")
public class Exercise {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "number_of_repetitions", nullable = false)
    private Integer numberOfRepetitions;
    @Basic
    @Column(name = "approach", nullable = false)
    private Integer approach;
    @Basic
    @Column(name = "complexity")
    private Integer complexity;
    @Basic
    @Column(name = "type_of_muscle_load_on", length = 30, nullable = false)
    private String typeOfMuscleLoadOn;
    @ManyToMany(mappedBy = "exercises")
    private Set<PersonalTraining> personalTrainings;
    @ManyToOne
    @JoinColumn(name = "personal_exercise_machine_id", referencedColumnName = "id", nullable = false)
    private PersonalExerciseMachine personalExerciseMachine;

    public Set<PersonalTraining> getPersonalTrainings() {
        return personalTrainings;
    }

    public void setPersonalTrainings(
        Set<PersonalTraining> personalTrainings) {
        this.personalTrainings = personalTrainings;
    }

    public PersonalExerciseMachine getPersonalExerciseMachine() {
        return personalExerciseMachine;
    }

    public void setPersonalExerciseMachine(
        PersonalExerciseMachine personalExerciseMachine) {
        this.personalExerciseMachine = personalExerciseMachine;
    }
}
