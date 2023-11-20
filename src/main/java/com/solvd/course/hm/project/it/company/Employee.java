package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.interfaces.TeamMember;

import java.util.Objects;
abstract class Employee extends Person implements TeamMember {
    private int employeeId;
    private ProjectA projectA;

    public Employee(String name, int employeeId) {
        super(name);
        this.employeeId = employeeId;
        this.projectA = projectA;
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
        return employeeId == employee.employeeId && Objects.equals(projectA, employee.projectA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, projectA);
    }

    public abstract ProjectA getProjectA();
}