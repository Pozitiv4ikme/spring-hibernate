package ua.lviv.iot.spring_hibernate_back_end.domain;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "trainer", schema = "study_iot", catalog = "")
public class Trainer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name", length = 25, nullable = false)
    private String name;
    @Basic
    @Column(name = "surname", length = 35, nullable = false)
    private String surname;
    @Basic
    @Column(name = "phone", length = 12, nullable = false)
    private String phone;
    @OneToMany(mappedBy = "trainer")
    private List<FreeGroupTraining> freeGroupTrainingsById;
    @OneToMany(mappedBy = "trainer")
    private List<PersonalTraining> personalTrainingsById;
    @ManyToOne
    @JoinColumn(name = "gym_id", referencedColumnName = "id", nullable = false)
    private Gym gym;

    public List<FreeGroupTraining> getFreeGroupTrainingsById() {
        return freeGroupTrainingsById;
    }

    public void setFreeGroupTrainingsById(
        List<FreeGroupTraining> freeGroupTrainingsById) {
        this.freeGroupTrainingsById = freeGroupTrainingsById;
    }

    public List<PersonalTraining> getPersonalTrainingsById() {
        return personalTrainingsById;
    }

    public void setPersonalTrainingsById(
        List<PersonalTraining> personalTrainingsById) {
        this.personalTrainingsById = personalTrainingsById;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}
