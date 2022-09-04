package fr.m2i.smartplannerspring.entities;

import javax.persistence.*;

@Entity
@Table(name="events")
@NamedQueries({
        @NamedQuery(name="selectAllEvents", query="SELECT event FROM Event event ORDER BY dateDebutTimestamp"),
        @NamedQuery(name="selectEventsByUser", query="SELECT event FROM Event event WHERE userId = :idUser ORDER BY dateDebutTimestamp"),
        @NamedQuery(name="findEventById", query="SELECT event FROM Event event WHERE id=:id")
})
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="user_id")
    private Integer userId;
    @Column(name="date_debut_timestamp")
    private Long dateDebutTimestamp;
    @Column(name="date_fin_timestamp")
    private Long dateFinTimestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getDateDebutTimestamp() {
        return dateDebutTimestamp;
    }

    public void setDateDebutTimestamp(Long dateDebutTimestamp) {
        this.dateDebutTimestamp = dateDebutTimestamp;
    }

    public Long getDateFinTimestamp() {
        return dateFinTimestamp;
    }

    public void setDateFinTimestamp(Long dateFinTimestamp) {
        this.dateFinTimestamp = dateFinTimestamp;
    }

    public Event(){}

    public Event(Integer id, String name, String description, Integer userId, Long dateDebutTimestamp, Long dateFinTimestamp){
        this.id=id;
        this.name=name;
        this.description=description;
        this.userId=userId;
        this.dateDebutTimestamp=dateDebutTimestamp;
        this.dateFinTimestamp=dateFinTimestamp;
    }

}