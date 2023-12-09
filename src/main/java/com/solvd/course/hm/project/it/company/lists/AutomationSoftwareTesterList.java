package com.solvd.course.hm.project.it.company.lists;

import com.solvd.course.hm.project.it.company.AutomationSoftwareTester;
import com.solvd.course.hm.project.it.company.Person;
import com.solvd.course.hm.project.it.company.ProjectDetails;
import com.solvd.course.hm.project.it.company.enums.*;

import java.util.ArrayList;
import java.util.List;

public class AutomationSoftwareTesterList {
    public static List<AutomationSoftwareTester> getAutomationSoftwareTestersList() {

        List<AutomationSoftwareTester> testers = new ArrayList<>();

        testers.add(new AutomationSoftwareTester("Michael", 1, new ProjectDetails(ProjectTypes.MOBILE_APP, Technologies.JAVA, ProjectStatus.IN_PROGRESS), OrganisationRole.TESTER, CompanyDepartment.FINANCE));
        testers.add(new AutomationSoftwareTester("Adam", 4, new ProjectDetails(ProjectTypes.DESKTOP_APP, Technologies.JAVA, ProjectStatus.CANCELED), OrganisationRole.TESTER, CompanyDepartment.IT));
        testers.add(new AutomationSoftwareTester("John", 7, new ProjectDetails(ProjectTypes.WEB_APP, Technologies.JAVA, ProjectStatus.ON_HOLD), OrganisationRole.TESTER, CompanyDepartment.FINANCE));
        testers.add(new AutomationSoftwareTester("Peter", 10, new ProjectDetails(ProjectTypes.DATA_SCIENCE_PROJECT, Technologies.PYTHON, ProjectStatus.COMPLETED), OrganisationRole.TESTER, CompanyDepartment.OPERATIONS));

        return testers;
    }
}
