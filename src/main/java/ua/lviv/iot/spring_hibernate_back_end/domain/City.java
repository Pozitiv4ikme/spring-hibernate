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
@Table(name = "city", schema = "study_iot", catalog = "")
public class City {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name", length = 25, nullable = false)
    private String name;
    @OneToMany(mappedBy = "city")
    private List<Gym> gymsById;

    public List<Gym> getGymsById() {
        return gymsById;
    }

    public void setGymsById(List<Gym> gymsById) {
        this.gymsById = gymsById;
    }
}
