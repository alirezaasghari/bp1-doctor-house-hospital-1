package at.refugeescode.accountancy.persistence.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    private Double cost;

    private LocalDateTime dateTime;

    @OneToOne(cascade = CascadeType.ALL)
    private Patient patient;

    public Invoice() {
    }

    public Invoice(Double cost, LocalDateTime dateTime, Patient patient) {
        this.cost = cost;
        this.dateTime = dateTime;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", cost=" + cost +
                ", dateTime=" + dateTime +
                ", patient=" + patient +
                '}';
    }
}
