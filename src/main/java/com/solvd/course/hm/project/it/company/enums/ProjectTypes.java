package com.solvd.course.hm.project.it.company.enums;

public enum ProjectTypes {
    WEB_APP("Web Application"),
    MOBILE_APP("Mobile Application"),
    DESKTOP_APP("Desktop Application"),
    EMBEDDED_SYSTEM("Embedded System"),
    DATA_SCIENCE_PROJECT("Data Science Project");

    private final String projectType;

    ProjectTypes(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectType() {
        return projectType;
    }
}
