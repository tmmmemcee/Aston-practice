package com.astontech.hr.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Employee extends Person {
    private String background;

    @OneToMany
    private List<Project> projects;

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
