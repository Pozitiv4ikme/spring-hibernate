package ua.lviv.iot.spring_hibernate_back_end.domain;

import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "gym", schema = "study_iot", catalog = "")
public class Gym {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "phone", length = 12, nullable = false)
    private String phone;
    @Basic
    @Column(name = "street_address", length = 50, nullable = false)
    private String streetAddress;
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private City city;
    @OneToMany(mappedBy = "gym")
    private List<Trainer> trainersById;
    @ManyToMany
    @JoinTable(name = "client_gym", catalog = "", schema = "study_iot", joinColumns = @JoinColumn(name = "gym_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false))
    private Set<Client> clients;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Trainer> getTrainersById() {
        return trainersById;
    }

    public void setTrainersById(List<Trainer> trainersById) {
        this.trainersById = trainersById;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
