package ua.lviv.iot.spring_hibernate_back_end.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "free_group_training", schema = "study_iot", catalog = "")
public class FreeGroupTraining {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "id", nullable = false)
    private Trainer trainer;
    @ManyToOne
    @JoinColumn(name = "free_group_program_id", referencedColumnName = "id", nullable = false)
    private FreeGroupProgram freeGroupProgramByFreeGroupProgramId;

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public FreeGroupProgram getFreeGroupProgramByFreeGroupProgramId() {
        return freeGroupProgramByFreeGroupProgramId;
    }

    public void setFreeGroupProgramByFreeGroupProgramId(
        FreeGroupProgram freeGroupProgramByFreeGroupProgramId) {
        this.freeGroupProgramByFreeGroupProgramId = freeGroupProgramByFreeGroupProgramId;
    }
}
