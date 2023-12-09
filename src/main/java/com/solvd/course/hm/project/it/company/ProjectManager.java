package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.enums.CompanyDepartment;
import com.solvd.course.hm.project.it.company.enums.OrganisationRole;
import com.solvd.course.hm.project.it.company.interfaces.ManagerActions;

import java.util.Objects;

public class ProjectManager extends Manager {


    public ProjectManager(String name, int employeeId, ProjectDetails projectDetails, OrganisationRole organisationRole, CompanyDepartment companyDepartment) {
        super(name, employeeId, projectDetails, organisationRole, companyDepartment);
    }

    @Override
    public void workOnProject() {
        System.out.println(getName() + " is managing the project scope.");
    }

    ManagerActions<String> manageTeamLambda = team -> System.out.println("Managing team: " + team);

    @Override
    protected int getTeamSize() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProjectManager that = (ProjectManager) o;
        return Objects.equals(super.getProjectDetails(), that.getProjectDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), super.getProjectDetails());
    }

    @Override
    public String toString() {
        return getName()+
                " - ProjectManager{" +
                "projectA=" + super.getProjectDetails() +
                '}';
    }
}
