package com.infoshareacademy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "COMPUTERS")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "operatingsystem")
    private String operatingSystem;


    public Computer() {

    }
    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Computer(String name, String operatingSystem) {
        this.name = name;
        this.operatingSystem = operatingSystem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Computer{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", operatingSystem='").append(operatingSystem).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
