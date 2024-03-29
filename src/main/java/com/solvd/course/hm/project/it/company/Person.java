package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.enums.OrganisationRole;
import com.solvd.course.hm.project.it.company.exceptions.InvalidNameException;

public class   Person {
    private String name;
    private OrganisationRole organisationRole ;

    public Person(String name, OrganisationRole organisationRole) throws InvalidNameException {
        validateName(name);
        this.name = name;
        this.organisationRole = organisationRole;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) throws InvalidNameException {
        if (name == null || !name.matches("^[a-zA-Z]+( [a-zA-Z]+)*$")) {
            throw new InvalidNameException("Invalid name: " + name);
        }
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }
}