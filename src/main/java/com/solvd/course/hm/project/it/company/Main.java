package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.exceptions.InvalidTechnologiesException;
import com.solvd.course.hm.project.it.company.exceptions.InvalidNameException;
import com.solvd.course.hm.project.it.company.exceptions.InvalidTechnologiesException;
import com.solvd.course.hm.project.it.company.exceptions.UnauthorizedAccessException;
import com.solvd.course.hm.project.it.company.interfaces.CEOActions;
import com.solvd.course.hm.project.it.company.interfaces.Developer;
import com.solvd.course.hm.project.it.company.interfaces.TeamMember;
import com.solvd.course.hm.project.it.company.interfaces.Tester;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        AutomotiveSoftwareTester tester = new AutomotiveSoftwareTester("Michael", 1, new ProjectA("WEB App", Technologies.JAVA));
        SoftwareDeveloper developer = new SoftwareDeveloper("Ola", 2, new ProjectA("WEB App", Technologies.JAVA));
        ProjectManager projectManager = new ProjectManager("John", 3, "A", new ProjectA("App", Technologies.JAVA));
        CEO ceo = new CEO("Frank", 100);

        Map<String, Object> employeeMap = new HashMap<>();
        CustomLinkedList<Person> peopleList = new CustomLinkedList<>();
        Queue<Person> peopleQueue = new LinkedList<>();

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

        tester.runTests();
        tester.workOnProject();
        System.out.println(tester);
        System.out.println();

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


        projectManager.manageTeam();
        projectManager.workOnProject();
        System.out.println(projectManager);
        System.out.println();


        ceo.workOnProject();
        ceo.defineCompanyStrategy();
        ceo.revealSecretCode();
        CEO.printSharePrice();
        System.out.println(ceo);

    }
}