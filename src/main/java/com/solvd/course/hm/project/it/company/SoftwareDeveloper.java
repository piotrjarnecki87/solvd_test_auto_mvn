package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.enums.CompanyDepartment;
import com.solvd.course.hm.project.it.company.enums.OrganisationRole;
import com.solvd.course.hm.project.it.company.enums.Technologies;
import com.solvd.course.hm.project.it.company.exceptions.InvalidTechnologiesException;
import com.solvd.course.hm.project.it.company.interfaces.Developer;

import java.util.Objects;

public class SoftwareDeveloper extends Employee implements Developer {

    public SoftwareDeveloper(String name, int employeeId, ProjectDetails projectDetails, OrganisationRole organisationRole, CompanyDepartment companyDepartment) {
        super(name, employeeId, projectDetails, organisationRole, companyDepartment);

    }
    @Override
    public void writeCode() throws InvalidTechnologiesException {
        if (!isValidTechnology(getProjectDetails().getTechnologies())) {
            throw new InvalidTechnologiesException("Invalid technology for writing code: " + getProjectDetails().getTechnologies());
        }

        System.out.println(getName() + " - Software Developer is writing code in " + getProjectDetails().getTechnologies());
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
        return Objects.equals(getProjectDetails(), that.getProjectDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getProjectDetails());
    }

    @Override
    public String toString() {
        return getName() +
                " ,projectdetails=" + getProjectDetails() +
                '}';
    }

}