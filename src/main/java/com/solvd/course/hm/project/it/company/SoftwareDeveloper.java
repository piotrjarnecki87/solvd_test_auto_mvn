package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.exceptions.InvalidTechnologiesException;
import com.solvd.course.hm.project.it.company.interfaces.Developer;

import java.util.Objects;

public class SoftwareDeveloper extends Employee implements Developer {

    public SoftwareDeveloper(String name, int employeeId, ProjectA projectA) {
        super(name, employeeId, projectA);

    }
    @Override
    public void writeCode() throws InvalidTechnologiesException {
        if (!isValidTechnology(getProjectA().getTechnologies())) {
            throw new InvalidTechnologiesException("Invalid technology for writing code: " + getProjectA().getTechnologies());
        }

        System.out.println(getName() + " - Software Developer is writing code in " + getProjectA().getTechnologies());
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
        return Objects.equals(getProjectA(), that.getProjectA());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getProjectA());
    }

    @Override
    public String toString() {
        return getName() +
                " ,projectA=" + getProjectA() +
                '}';
    }
}