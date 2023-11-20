package com.solvd.course.hm.project.it.company;

import java.util.HashSet;
import java.util.Set;

public class ProjectA {
    private String projectName;
    private Technologies technologies;

    private static Set<ProjectA> projectSet = new HashSet<>();
    public static Set<ProjectA> getProjectSet() {
        return projectSet;
    }

    public String getProjectName() {
        return projectName;
    }

    public Technologies getTechnologies() {
        return technologies;
    }


    public ProjectA(String projectName, Technologies technologies) {
        this.projectName = projectName;
        this.technologies = technologies;
    }

    @Override
    public String toString() {
        return "ProjectA{" +
                "projectName='" + projectName + '\'' +
                ", technologies='" + technologies.getDescription() + '\'' +
                '}';
    }
}