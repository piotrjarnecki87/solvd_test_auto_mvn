package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.interfaces.ManagerActions;

import java.util.Objects;

public class ProjectManager extends Manager implements ManagerActions {
    private ProjectA projectA;

    public ProjectManager(String name, int employeeId,String department, ProjectA projectA) {
        super(name, employeeId, department);
        this.projectA = projectA;

    }

    @Override
    public void workOnProject() {
        System.out.println(getName() + " is managing the project scope.");
    }

    @Override
    public ProjectA getProjectA() {
        return projectA;
    }

    @Override
    public void manageTeam() {
        System.out.println(getName() + " - Project Manager is managing the team.");
    }

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
        return Objects.equals(projectA, that.projectA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), projectA);
    }

    @Override
    public String toString() {
        return getName()+
                " - ProjectManager{" +
                "projectA=" + projectA +
                '}';
    }
}
