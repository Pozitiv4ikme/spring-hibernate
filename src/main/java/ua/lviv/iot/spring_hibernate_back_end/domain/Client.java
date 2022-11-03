package ua.lviv.iot.spring_hibernate_back_end.domain;

import java.time.LocalDate;
import java.util.Date;
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
@Table(name = "client", schema = "study_iot", catalog = "")
public class Client {

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
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;
    @Basic
    @Column(name = "phone", length = 12, nullable = false)
    private String phone;
    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id", nullable = false)
    private Gender gender;
    @ManyToMany(mappedBy = "clients")
    private Set<Gym> gyms;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<Gym> getGyms() {
        return gyms;
    }

    public void setGyms(Set<Gym> gyms) {
        this.gyms = gyms;
    }
}
