package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.enums.*;
import com.solvd.course.hm.project.it.company.exceptions.InvalidTechnologiesException;

import java.util.*;
import java.util.function.Consumer;


public class Main {
    private static final TechnologyValidator technologyValidator = new TechnologyValidator();
    public static void main(String[] args) {

        AutomotiveSoftwareTester tester = new AutomotiveSoftwareTester("Michael", 1, new ProjectDetails(ProjectTypes.MOBILE_APP, Technologies.JAVA, ProjectStatus.IN_PROGRESS), OrganisationRole.TESTER, CompanyDepartment.FINANCE);
        SoftwareDeveloper developer = new SoftwareDeveloper("Ola", 2, new ProjectDetails(ProjectTypes.DESKTOP_APP, Technologies.JAVA, ProjectStatus.CANCELED), OrganisationRole.FREELANCER, CompanyDepartment.OPERATIONS);
        ProjectManager projectManager = new ProjectManager("John", 3, "A", new ProjectDetails(ProjectTypes.DATA_SCIENCE_PROJECT, Technologies.JAVA, ProjectStatus.ON_HOLD), OrganisationRole.PROJECT_MANAGER,CompanyDepartment.MARKETING);
        CEO ceo = new CEO("Frank", 100,OrganisationRole.CEO);

        Map<String, Object> employeeMap = new HashMap<>();
        CustomLinkedList<Person> peopleList = new CustomLinkedList<>();
        Queue<Person> peopleQueue = new LinkedList<>();

        Consumer<Person> printPersonName = person -> System.out.println("Name: " + person.getName());
        printPersonName.accept(developer);

        Runnable runTestsAndWorkOnProject = () -> {
            tester.testerLambda.runTests("unit tests");
            tester.workOnProject();
            System.out.println(tester);
            System.out.println();
        };
        runTestsAndWorkOnProject.run();


        employeeMap.put("Tester", tester);
        employeeMap.put("Developer", developer);
        employeeMap.put("ProjectManager", projectManager);

        peopleList.add(tester);
        peopleList.add(developer);
        peopleList.add(projectManager);
        peopleList.add(ceo);

        peopleQueue.addAll(Arrays.asList(tester, developer, projectManager, ceo));

        int numberOfEmployees = employeeMap.size();
        System.out.println("Number of employees in the map: " + numberOfEmployees);


        if (technologyValidator.isValidTechnology(tester.getProjectDetails().getTechnologies())) {
            tester.testerLambda.runTests("unit tests");
            tester.workOnProject();
            System.out.println(tester);
            System.out.println();
        } else {
            System.out.println("Invalid technology for tester: " + tester.getProjectDetails().getTechnologies());
        }

        Person firstPerson = peopleQueue.peek();
        System.out.println("First person in the queue: " + firstPerson.getName());

        Person removedPerson = peopleQueue.poll();
        System.out.println("Removed person from the queue: " + removedPerson.getName());

        for (Person person : peopleList) {

            System.out.println("Name: " + person.getName());
        }

        try {
            developer.writeCode();
        } catch (InvalidTechnologiesException e) {
            throw new RuntimeException(e);
        }
        developer.workOnProject();
        System.out.println(developer);
        System.out.println();

        System.out.println();


        projectManager.manageTeamLambda.manageTeam(CompanyDepartment.HR.getDepartmentType());
        projectManager.workOnProject();
        System.out.println(projectManager);
        System.out.println();


        ceo.workOnProject();
        ceo.ceoStrategy.defineCompanyStrategy("Aggressive Expansion");
        ceo.revealSecretCode();
        CEO.printSharePrice();
        System.out.println(ceo);

        ProjectDetails projectDetailsTester = tester.getProjectDetails();
        String testerStatusText = projectDetailsTester.getStatusText();
        System.out.println(testerStatusText);


    }
}