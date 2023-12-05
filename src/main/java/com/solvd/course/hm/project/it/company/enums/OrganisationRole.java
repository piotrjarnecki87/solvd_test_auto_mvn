package com.solvd.course.hm.project.it.company.enums;

public enum OrganisationRole {
    EMPLOYEE("Employee"),
    TESTER("Tester"),
    DEVELOPER("Developer"),
    PROJECT_MANAGER("Project Manager"),
    CEO("CEO"),
    FREELANCER("Freelancer"),
    CONSULTANT("Consultant"),
    INTERN("Intern");

    private final String roleName;

    OrganisationRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
