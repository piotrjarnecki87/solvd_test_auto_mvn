package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.enums.CompanyDepartment;
import com.solvd.course.hm.project.it.company.enums.OrganisationRole;
import com.solvd.course.hm.project.it.company.interfaces.TeamMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
public class Employee extends Person implements TeamMember {
    private int employeeId;
    private CompanyDepartment companyDepartment;
    private ProjectDetails projectDetails;

    public Employee(String name, int employeeId, ProjectDetails projectDetails, OrganisationRole organisationRole, CompanyDepartment companyDepartment ) {
        super(name, organisationRole);
        this.employeeId = employeeId;
        this.projectDetails = projectDetails;
        this.companyDepartment = companyDepartment;
    }

    public int getEmployeeId() {
        return employeeId;
    }


    @Override
    public void workOnProject() {
        System.out.println(getName() + " is working on the project.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId && Objects.equals(projectDetails, employee.projectDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, projectDetails);
    }

    public ProjectDetails getProjectDetails() {
        return projectDetails;
    }

    public void setProjectA(ProjectDetails projectDetails) {
        this.projectDetails = projectDetails;
    }



}