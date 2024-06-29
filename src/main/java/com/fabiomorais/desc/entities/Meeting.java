package com.fabiomorais.desc.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_meeting")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topic;
    private String instructor;
    private LocalDate date;

    @OneToMany(mappedBy = "meeting")
    private Set<Attendance> attendances;

    public Meeting(){}

    public Meeting(Long id, String topic, String instructor, LocalDate date) {
        this.id = id;
        this.topic = topic;
        this.instructor = instructor;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Attendance> getAttendances() {
        return attendances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(id, meeting.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
