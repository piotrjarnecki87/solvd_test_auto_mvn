package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.enums.Technologies;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TechnologyValidator {

    private static final List<Technologies> SUPPORTED_TECHNOLOGIES = Arrays.asList(Technologies.JAVA, Technologies.PYTHON);

    public static Predicate<Technologies> isValidTechnology = technology -> SUPPORTED_TECHNOLOGIES.contains(technology);

    public static boolean isValidTechnology(Technologies technology) {
        return isValidTechnology.test(technology);
    }
}