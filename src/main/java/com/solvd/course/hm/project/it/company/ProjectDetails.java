package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.enums.ProjectStatus;
import com.solvd.course.hm.project.it.company.enums.ProjectTypes;
import com.solvd.course.hm.project.it.company.enums.Technologies;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class ProjectDetails {
    private ProjectTypes projectTypes;
    private Technologies technologies;
    private ProjectStatus projectStatus;

    private static Set<ProjectDetails> projectSet = new HashSet<>();
    public ProjectDetails(ProjectTypes projectTypes, Technologies technologies, ProjectStatus projectStatus ) {
        this.projectTypes = projectTypes;
        this.technologies = technologies;
        this.projectStatus = projectStatus;
    }


    public Set<ProjectDetails> copyProjectSet(){
        return new HashSet<>(projectSet);
    }

    public ProjectTypes getProjectTypes() {
        return projectTypes;
    }

    public Technologies getTechnologies() {
        return technologies;
    }

    public static Set<ProjectDetails> getProjectSet() {
        return projectSet;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    @Override
    public String toString() {
        return "ProjectA{" +
                "projectType='" + projectTypes + '\'' +
                ", technologies='" + technologies.getDescription() + '\'' +
                '}';
    }
    public String getStatusText() {
        Function<ProjectStatus, String> statusToString = status -> {
            switch (status) {
                case IN_PROGRESS:
                    return "In Progress";
                case CANCELED:
                    return "Canceled";
                case ON_HOLD:
                    return "On Hold";
                default:
                    return "Unknown";
            }
        };

        String statusText = statusToString.apply(projectStatus);

        // Warunek if-else przeniesiony do metody getStatusText
        if ("In Progress".equals(statusText)) {
            return "Project is in progress.";
        } else {
            return "Project is not in progress.";
        }
    }
}