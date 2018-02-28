package com.infoshareacademy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "STUDENTS")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    @OneToOne
    @JoinColumn(name = "computer_id", unique = true)
    private Computer computer;


    public Student() {

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Student(String name, String surname, LocalDate dateOfBirth, Computer computer) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.computer = computer;
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
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", computer=").append(computer);
        sb.append('}');
        return sb.toString();
    }
}
