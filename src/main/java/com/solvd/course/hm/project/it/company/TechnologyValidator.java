package com.solvd.course.hm.project.it.company;

import java.util.Arrays;
import java.util.List;

public class TechnologyValidator {

    private static final List<Technologies> SUPPORTED_TECHNOLOGIES = Arrays.asList(Technologies.JAVA, Technologies.PYTHON);

    public static boolean isValidTechnology(Technologies technology) {
        return SUPPORTED_TECHNOLOGIES.contains(technology);
    }
}