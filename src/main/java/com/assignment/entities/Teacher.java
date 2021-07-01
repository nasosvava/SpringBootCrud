package com.assignment.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Nasos
 */
@Entity
public class Teacher {

    private Long id;
    @NotEmpty(message = "Teacher's first name cannot be empty.")
    @Size(min = 5, max = 25, message = "Teacher's first name must be between 3 and 25 char long")
    @Pattern(regexp = "^([a-zA-Z]+\\s?)*$", message = "The First Name can contain only latin letters")
    private String fName;
    @NotEmpty(message = "Teachers's last name cannot be empty.")
    @Size(min = 5, max = 25, message = "Teacher's last name must be between 3 and 25 char long")
    @Pattern(regexp = "[a-zA-Z]+", message = "The Last Name can't contain numbers or spaces")
    private String lName;
    @NotEmpty(message = "Teachers subject cannot be empty.")
    @Size(min = 5, max = 250, message = "Teacher's subject must be between 3 and 250 char long")
    private String subject;

    public Teacher() {
    }

    public Teacher(Long id, String fName, String lName, String subject) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.subject = subject;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", subject=" + subject + '}';
    }

}
