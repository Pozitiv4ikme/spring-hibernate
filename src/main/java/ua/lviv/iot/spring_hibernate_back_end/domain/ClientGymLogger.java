package ua.lviv.iot.spring_hibernate_back_end.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "client_gym_logger", schema = "study_iot", catalog = "")
public class ClientGymLogger {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "gym_id", nullable = false)
    private Integer gymId;
    @Basic
    @Column(name = "client_id", nullable = false)
    private Integer clientId;
    @Basic
    @Column(name = "action", length = 8, nullable = false)
    private String action;
    @Basic
    @Column(name = "edit_user", length = 30, nullable = false)
    private String editUser;
    @Basic
    @Column(name = "edit_time", nullable = false)
    private String editTime;
}
