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
@Table(name = "free_group_program", schema = "study_iot", catalog = "")
public class FreeGroupProgram {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "day", length = 12, nullable = false)
    private String day;
    @Basic
    @Column(name = "exercise", length = 30, nullable = false)
    private String exercise;
    @OneToMany(mappedBy = "freeGroupProgramByFreeGroupProgramId")
    private List<FreeGroupTraining> freeGroupTrainingsById;

    public List<FreeGroupTraining> getFreeGroupTrainingsById() {
        return freeGroupTrainingsById;
    }

    public void setFreeGroupTrainingsById(
        List<FreeGroupTraining> freeGroupTrainingsById) {
        this.freeGroupTrainingsById = freeGroupTrainingsById;
    }
}
