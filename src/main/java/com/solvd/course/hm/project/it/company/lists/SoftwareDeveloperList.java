package com.solvd.course.hm.project.it.company.lists;

import com.solvd.course.hm.project.it.company.AutomationSoftwareTester;
import com.solvd.course.hm.project.it.company.ProjectDetails;
import com.solvd.course.hm.project.it.company.SoftwareDeveloper;
import com.solvd.course.hm.project.it.company.enums.*;

import java.util.ArrayList;
import java.util.List;

public class SoftwareDeveloperList {
    public static List<SoftwareDeveloper> getSoftwareDeveloperListList() {

        List<SoftwareDeveloper> developers = new ArrayList<>();

        developers.add(new SoftwareDeveloper("Ola", 2, new ProjectDetails(ProjectTypes.DESKTOP_APP, Technologies.JAVA, ProjectStatus.CANCELED), OrganisationRole.FREELANCER, CompanyDepartment.OPERATIONS));
        developers.add(new SoftwareDeveloper("Bryan", 6, new ProjectDetails(ProjectTypes.WEB_APP, Technologies.JAVA, ProjectStatus.COMPLETED), OrganisationRole.FREELANCER, CompanyDepartment.OPERATIONS));
        developers.add(new SoftwareDeveloper("Megan", 9, new ProjectDetails(ProjectTypes.DATA_SCIENCE_PROJECT, Technologies.PYTHON, ProjectStatus.IN_PROGRESS), OrganisationRole.FREELANCER, CompanyDepartment.OPERATIONS));
        developers.add(new SoftwareDeveloper("Kristofer", 12, new ProjectDetails(ProjectTypes.MOBILE_APP, Technologies.JAVA, ProjectStatus.ON_HOLD), OrganisationRole.FREELANCER, CompanyDepartment.OPERATIONS));
        return developers;
    }
}
