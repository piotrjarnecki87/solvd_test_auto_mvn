package com.solvd.course.hm.project.it.company.enums;

public enum ProjectStatus {
    IN_PROGRESS("Project is currently in progress"),
    COMPLETED("Project has been completed successfully"),
    ON_HOLD("Project is on hold"),
    CANCELED("Project has been canceled");
    private String statusInfo;

    ProjectStatus(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getStatusInfo() {
        return statusInfo;
    }
}
