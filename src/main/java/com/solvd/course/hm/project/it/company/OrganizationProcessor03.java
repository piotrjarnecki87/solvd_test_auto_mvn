package com.solvd.course.hm.project.it.company;

import java.util.function.Consumer;

public class OrganizationProcessor03 implements Runnable {
    @Override
    public void run(){
        Consumer<Person> printPersonName = person -> System.out.println("Name: " + person.getName());

    }
}
