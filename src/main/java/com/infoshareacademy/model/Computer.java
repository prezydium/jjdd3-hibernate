package com.infoshareacademy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COMPUTERS")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 32)
    @NotNull
    private String name;

    @Column(name = "operating_system", length = 64)
    @NotNull
    private String operatingSystem;

    public Computer() {
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

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
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
