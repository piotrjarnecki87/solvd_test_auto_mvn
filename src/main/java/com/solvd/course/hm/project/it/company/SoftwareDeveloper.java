package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.exceptions.InvalidTechnologiesException;
import com.solvd.course.hm.project.it.company.interfaces.Developer;

import java.util.Objects;

public class SoftwareDeveloper extends Employee implements Developer {

    private ProjectA projectA;

    public SoftwareDeveloper(String name, int employeeId, ProjectA projectA) {
        super(name, employeeId);
        this.projectA = projectA;

    }

    @Override
    public ProjectA getProjectA() {
        return projectA;
    }

    @Override
    public void writeCode() throws InvalidTechnologiesException {
        if (!isValidTechnology(projectA.getTechnologies())) {
            throw new InvalidTechnologiesException("Invalid technology for writing code: " + projectA.getTechnologies());
        }

        System.out.println(getName() + " - Software Developer is writing code in " + projectA.getTechnologies());
    }
    private boolean isValidTechnology(Technologies technology) {
        return TechnologyValidator.isValidTechnology(technology);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SoftwareDeveloper that = (SoftwareDeveloper) o;
        return Objects.equals(projectA, that.projectA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), projectA);
    }

    @Override
    public String toString() {
        return getName() +
                " ,projectA=" + projectA +
                '}';
    }
}