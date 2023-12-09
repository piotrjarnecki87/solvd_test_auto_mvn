package com.solvd.course.hm.project.it.company.lists;

import com.solvd.course.hm.project.it.company.ProjectDetails;
import com.solvd.course.hm.project.it.company.ProjectManager;
import com.solvd.course.hm.project.it.company.enums.*;

import java.util.ArrayList;
import java.util.List;

public class ProjectManagerList {

    public static List<ProjectManager> getProjectManagerList() {

        List<ProjectManager> projectManagers = new ArrayList<>();

        projectManagers.add(new ProjectManager("John", 3, new ProjectDetails(ProjectTypes.DATA_SCIENCE_PROJECT, Technologies.JAVA, ProjectStatus.ON_HOLD), OrganisationRole.PROJECT_MANAGER, CompanyDepartment.IT));
        projectManagers.add(new ProjectManager("Michael", 5, new ProjectDetails(ProjectTypes.DATA_SCIENCE_PROJECT, Technologies.JAVA, ProjectStatus.ON_HOLD), OrganisationRole.PROJECT_MANAGER, CompanyDepartment.MARKETING));
        projectManagers.add(new ProjectManager("Peter", 8, new ProjectDetails(ProjectTypes.DATA_SCIENCE_PROJECT, Technologies.JAVA, ProjectStatus.ON_HOLD), OrganisationRole.PROJECT_MANAGER, CompanyDepartment.FINANCE));
        projectManagers.add(new ProjectManager("Francesca", 11, new ProjectDetails(ProjectTypes.DATA_SCIENCE_PROJECT, Technologies.PYTHON, ProjectStatus.ON_HOLD), OrganisationRole.PROJECT_MANAGER, CompanyDepartment.OPERATIONS));

        return projectManagers;
    }
}
