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
@Table(name = "gender", schema = "study_iot", catalog = "")
public class Gender {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "type", length = 40, nullable = false)
    private String type;
    @OneToMany(mappedBy = "gender")
    private List<Client> clients;

    public List<Client> getClientsById() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
