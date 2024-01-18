package com.solvd.course.hm.project.it.company;


import com.solvd.course.hm.project.it.company.interfaces.Developer;
import com.solvd.course.hm.project.it.company.lists.AllPeopleInOrganization;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;


public class OrganizationProcessor01 extends Thread{
    private static final TechnologyValidator technologyValidator = new TechnologyValidator();
    List<Person> allPeople = AllPeopleInOrganization.getAllPeopleInOrganization();

    @Override
    public void run() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            processAutomationSoftwareTesters();
            printDeveloperNames();
            printNumberOfEmployees();
        });

        CompletableFuture<Void> processor03Future = future.thenCompose(result -> CompletableFuture.runAsync(() -> {
            OrganizationProcessor03 processor03 = new OrganizationProcessor03();
            processor03.run();
        }));

        processor03Future.join();
    }

    public void processAutomationSoftwareTesters() {
        allPeople.stream()
                .filter(person -> person instanceof AutomationSoftwareTester)
                .map(person -> (AutomationSoftwareTester) person)
                .filter(tester -> technologyValidator.isValidTechnology(tester.getProjectDetails().getTechnologies()))
                .forEach(tester -> {
                    tester.workOnProject();
                    System.out.println(tester);
                    System.out.println();
                });
    }
    public void printDeveloperNames() {
        allPeople.stream()
                .filter(person -> person instanceof Developer)
                .forEach(person -> System.out.println("Name: " + person.getName()));
    }

    public void printNumberOfEmployees() {
        long numberOfEmployees = allPeople.stream()
                .filter(person -> person instanceof Employee)
                .count();
        System.out.println("Number of employees in the list: " + numberOfEmployees);
    }
}
