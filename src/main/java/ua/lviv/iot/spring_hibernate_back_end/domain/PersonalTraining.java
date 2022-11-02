package ua.lviv.iot.spring_hibernate_back_end.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "personal_training", schema = "study_iot", catalog = "")
public class PersonalTraining {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @ManyToMany
    @JoinTable(name = "exercise_personal_training", catalog = "", schema = "study_iot", joinColumns = @JoinColumn(name = "personal_training_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "exercise_id", referencedColumnName = "id", nullable = false))
    private Set<Exercise> exercises;
    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "id", nullable = false)
    private Trainer trainer;

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
