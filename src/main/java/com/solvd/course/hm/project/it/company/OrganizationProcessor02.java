package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.enums.CompanyDepartment;
import com.solvd.course.hm.project.it.company.enums.Technologies;
import com.solvd.course.hm.project.it.company.exceptions.InvalidTechnologiesException;
import com.solvd.course.hm.project.it.company.interfaces.Developer;
import com.solvd.course.hm.project.it.company.lists.AllPeopleInOrganization;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrganizationProcessor02 implements Runnable {

    List<Person> allPeople = AllPeopleInOrganization.getAllPeopleInOrganization();

    @Override
    public void run(){

        writeCodeForDevelopers();
        manageProjectsForManagers();
        printNumberOfPeople();
        printPythonEmployees();
        printSortedEmployees();
        executeCEOTasks();
    }

    public void writeCodeForDevelopers() {
        allPeople.stream()
                .filter(person -> person instanceof Developer)
                .map(person -> (Developer) person)
                .forEach(developer -> {
                    try {
                        developer.writeCode();
                        developer.writeCode();
                        System.out.println(developer);
                    } catch (InvalidTechnologiesException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public void manageProjectsForManagers() {
        allPeople.stream()
                .filter(person -> person instanceof ProjectManager)
                .map(person -> (ProjectManager) person)
                .forEach(projectManager -> {
                    projectManager.manageTeamLambda.manageTeam(CompanyDepartment.HR.getDepartmentType());
                    projectManager.workOnProject();
                    System.out.println(projectManager);
                });
    }
    public void executeCEOTasks() {
        allPeople.stream()
                .filter(person -> person instanceof CEO)
                .map(person -> (CEO) person)
                .forEach(ceo -> {
                    ceo.ceoStrategy.defineCompanyStrategy("Aggressive Expansion");
                    ceo.revealSecretCode();
                    CEO.printSharePrice();
                    System.out.println(ceo);
                });
    }
    public void printNumberOfPeople() {
        long numberOfPeople = allPeople.stream().count();
        System.out.println("Number of people in the organization: " + numberOfPeople);
    }
    public void printPythonEmployees() {
        List<Person> pythonEmployees = allPeople.stream()
                .filter(person -> person instanceof Employee)
                .map(person -> (Employee) person)
                .filter(employee -> employee.getProjectDetails().getTechnologies() == Technologies.PYTHON)
                .collect(Collectors.toList());

        System.out.println("Employees working with Technologies.PYTHON:");
        pythonEmployees.forEach(person -> System.out.println(person.getName()));
        System.out.println("Number of employees working with Technologies.PYTHON: " + pythonEmployees.size());
    }
    public void printSortedEmployees() {
        allPeople.stream()
                .filter(person -> person instanceof Employee)
                .map(person -> (Employee) person)
                .sorted(Comparator.comparingInt(Employee::getEmployeeId))
                .forEach(employee -> System.out.println(employee));
    }
}

