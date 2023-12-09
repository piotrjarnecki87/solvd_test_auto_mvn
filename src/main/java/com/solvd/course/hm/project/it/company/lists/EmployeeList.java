package com.solvd.course.hm.project.it.company.lists;

import com.solvd.course.hm.project.it.company.AutomationSoftwareTester;
import com.solvd.course.hm.project.it.company.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeeList {

    public static List<Person> getEmployeList(){
        List<Person> employees = new ArrayList<>();

        employees.addAll(AutomationSoftwareTesterList.getAutomationSoftwareTestersList());
        employees.addAll(ProjectManagerList.getProjectManagerList());
        employees.addAll(SoftwareDeveloperList.getSoftwareDeveloperListList());
        return employees;
    }
}
