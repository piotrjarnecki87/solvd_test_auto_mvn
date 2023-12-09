package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.enums.*;
import com.solvd.course.hm.project.it.company.exceptions.InvalidTechnologiesException;
import com.solvd.course.hm.project.it.company.interfaces.Developer;
import com.solvd.course.hm.project.it.company.lists.AllPeopleInOrganization;
import com.solvd.course.hm.project.it.company.lists.AutomationSoftwareTesterList;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.List;

public class Main {
    private static final TechnologyValidator technologyValidator = new TechnologyValidator();
    public static void main(String[] args) {
        List<Person> allPeople = AllPeopleInOrganization.getAllPeopleInOrganization();

        allPeople.stream()
                .filter(person -> person instanceof AutomationSoftwareTester)
                .map(person -> (AutomationSoftwareTester) person)
                .filter(tester -> technologyValidator.isValidTechnology(tester.getProjectDetails().getTechnologies()))
                .forEach(tester -> {
                    tester.workOnProject();
                    System.out.println(tester);
                    System.out.println();
                });

        Consumer<Person> printPersonName = person -> System.out.println("Name: " + person.getName());

        allPeople.stream()
                .filter(person -> person instanceof Developer)
                .forEach(printPersonName);

        long numberOfEmployees = allPeople.stream()
                .filter(person -> person instanceof Employee)
                .count();

        System.out.println("Number of employees in the list: " + numberOfEmployees);

        allPeople.stream()
                .filter(person -> person instanceof Developer)
                .map(person -> (Developer) person)
                .forEach(developer -> {
                    try {
                        developer.writeCode();
                    } catch (InvalidTechnologiesException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        developer.writeCode();
                    } catch (InvalidTechnologiesException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(developer);
                });

        allPeople.stream()
                .filter(person -> person instanceof ProjectManager)
                .map(person -> (ProjectManager)person)
                .forEach(projectManager -> {
                    projectManager.manageTeamLambda.manageTeam(CompanyDepartment.HR.getDepartmentType());
                    projectManager.workOnProject();
                    System.out.println(projectManager);
                });

        allPeople.stream()
                .filter(person -> person instanceof CEO)
                .map(person -> (CEO) person)
                .forEach(ceo -> {
                    ceo.ceoStrategy.defineCompanyStrategy("Aggressive Expansion");
                    ceo.revealSecretCode();
                    CEO.printSharePrice();
                    System.out.println(ceo);
                });

        long numberOfPeople = allPeople
                .stream()
                .count();

        System.out.println("Number of people in the organization: " + numberOfPeople);

        List<Person> pythonEmployees = allPeople.stream()
                .filter(person -> person instanceof Employee)
                .map(person -> (Employee) person)
                .filter(employee -> employee.getProjectDetails().getTechnologies() == Technologies.PYTHON)
                .collect(Collectors.toList());

        System.out.println("Employees working with Technologies.PYTHON:");
        pythonEmployees.forEach(person -> System.out.println(person.getName()));
        System.out.println("Number of employees working with Technologies.PYTHON: " + pythonEmployees.size());

        allPeople.stream()
                .filter(person -> person instanceof Employee)
                .map(person -> (Employee) person)
                .sorted(Comparator.comparingInt(Employee::getEmployeeId))
                .forEach(employee -> System.out.println(employee));

    }
}


