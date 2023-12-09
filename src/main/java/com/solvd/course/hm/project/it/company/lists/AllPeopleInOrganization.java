package com.solvd.course.hm.project.it.company.lists;

import com.solvd.course.hm.project.it.company.Person;

import java.util.ArrayList;
import java.util.List;

public class AllPeopleInOrganization {
    public static List<Person> getAllPeopleInOrganization(){
        List<Person> allPeople = new ArrayList<>();

        allPeople.addAll(EmployeeList.getEmployeList());
        allPeople.addAll(StakeholderList.getCeoList());

        return allPeople;
    }
}
