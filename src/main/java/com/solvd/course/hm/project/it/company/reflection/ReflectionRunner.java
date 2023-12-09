package com.solvd.course.hm.project.it.company.reflection;

import com.solvd.course.hm.project.it.company.*;
import com.solvd.course.hm.project.it.company.enums.*;
import com.solvd.course.hm.project.it.company.interfaces.TeamMember;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionRunner {
    public static void main(String[] args) {
        processClass(SoftwareDeveloper.class);
        processClass(ProjectManager.class);
        processClass(AutomationSoftwareTester.class);
        processClass(CEO.class);
    }

    private static void processClass(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("\nFields for class " + clazz.getSimpleName() + ":");
        Arrays.stream(fields).forEach(field -> System.out.println(field));

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.println("\nConstructors for class " + clazz.getSimpleName() + ":");
        Arrays.stream(constructors).forEach(constructor -> System.out.println(constructor));

        try {

            Object object = null;

            if (clazz.equals(SoftwareDeveloper.class)) {
                Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class, ProjectDetails.class, OrganisationRole.class, CompanyDepartment.class);
                object = constructor.newInstance("ExampleDeveloper", 1, new ProjectDetails(ProjectTypes.WEB_APP, Technologies.JAVA, ProjectStatus.IN_PROGRESS), OrganisationRole.DEVELOPER, CompanyDepartment.IT);
            } else if (clazz.equals(ProjectManager.class)) {
                Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class, ProjectDetails.class, OrganisationRole.class, CompanyDepartment.class);
                object = constructor.newInstance("ExampleManager", 2, new ProjectDetails(ProjectTypes.DATA_SCIENCE_PROJECT, Technologies.JAVA, ProjectStatus.ON_HOLD), OrganisationRole.PROJECT_MANAGER, CompanyDepartment.IT);
            } else if (clazz.equals(AutomationSoftwareTester.class)) {
                Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class, ProjectDetails.class, OrganisationRole.class, CompanyDepartment.class);
                object = constructor.newInstance("ExampleTester", 3, new ProjectDetails(ProjectTypes.MOBILE_APP, Technologies.JAVA, ProjectStatus.IN_PROGRESS), OrganisationRole.TESTER, CompanyDepartment.FINANCE);
            } else if (clazz.equals(CEO.class)) {
                Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class, OrganisationRole.class);
                object = constructor.newInstance("ExampleCEO", 100, OrganisationRole.CEO);
            }


            if (TeamMember.class.isAssignableFrom(clazz)) {
                Method workOnProjectMethod = clazz.getDeclaredMethod("workOnProject");
                workOnProjectMethod.invoke(object);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
