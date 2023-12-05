package com.solvd.course.hm.project.it.company.enums;

public enum CompanyDepartment {
    IT("Information Technology"),
    HR("Human Resources"),
    FINANCE("Finance"),
    MARKETING("Marketing"),
    OPERATIONS("Operations");

    private final String departmentType;

    CompanyDepartment(String departmentType) {
        this.departmentType = departmentType;
    }

    public String getDepartmentType() {
        return departmentType;
    }
}
