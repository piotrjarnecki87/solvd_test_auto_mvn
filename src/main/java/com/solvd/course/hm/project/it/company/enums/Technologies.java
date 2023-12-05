package com.solvd.course.hm.project.it.company.enums;

public enum Technologies {
    JAVA("Java"),
    PYTHON("Python");

    private String description;

    Technologies(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
//wprowadz konstruktor i rozszerz zakres
//static block