package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.enums.CompanyDepartment;
import com.solvd.course.hm.project.it.company.enums.OrganisationRole;
import com.solvd.course.hm.project.it.company.exceptions.InvalidTeamManagementException;
import com.solvd.course.hm.project.it.company.exceptions.log.ExceptionLogger;

abstract class Manager extends Employee {
    private String department;

    public Manager(String name, int employeeId, String department, ProjectDetails projectDetails, OrganisationRole organisationRole, CompanyDepartment companyDepartment ) {
            super(name, employeeId, projectDetails, organisationRole, companyDepartment);
        this.department = department;

    }

    @Override
    public void workOnProject() {
        System.out.println(getName() + " is managing the project.");
    }


    public void manageTeam() {
        try {
            if (isTeamManagementProblem()) {
                int teamSize = getTeamSize();
                String errorMessage = "Error in managing the team: Insufficient team members. Current team size: " + teamSize;
                System.err.println(errorMessage);
                ExceptionLogger.logExceptionToFile(new InvalidTeamManagementException(errorMessage));
                throw new InvalidTeamManagementException(errorMessage);
            }
        } catch (InvalidTeamManagementException e) {
            ExceptionLogger.logExceptionToFile(e);
            System.err.println("Invalid team management: " + e.getMessage());
        }
    }

    private boolean isTeamManagementProblem() {
        return getTeamSize() < 3;
    }
    protected abstract int getTeamSize();
}
