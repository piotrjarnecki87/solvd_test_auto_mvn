package com.solvd.course.hm.project.it.company;

import com.solvd.course.hm.project.it.company.enums.CompanyDepartment;
import com.solvd.course.hm.project.it.company.enums.OrganisationRole;
import com.solvd.course.hm.project.it.company.exceptions.TestExecutionException;
import com.solvd.course.hm.project.it.company.interfaces.Tester;

import java.util.Objects;
import java.util.function.Supplier;

public class AutomationSoftwareTester extends Employee {

    private Supplier<Boolean> testExecutionSupplier = () -> testExecutionFails();


    public AutomationSoftwareTester(String name, int employeeId, ProjectDetails projectDetails, OrganisationRole organisationRole, CompanyDepartment companyDepartment) {
        super(name, employeeId, projectDetails, organisationRole, companyDepartment);
    }

    Tester<String> testerLambda = tests -> System.out.println("Running tests: " + tests);

    @Override
    public void workOnProject() {
        try {
            if (getProjectDetails() != null) {
                System.out.println(getName() + " is running tests on the  " + getProjectDetails());

                if (testExecutionSupplier.get()) {
                    throw new TestExecutionException("Test execution failed!!.");
                } else {
                    System.out.println("Test execution successful.");
                }
            } else {
                throw new IllegalArgumentException(getName() + " is running tests on an undefined project.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("UndefinedProjectException caught: " + e.getMessage());

        } catch (TestExecutionException e) {
            System.out.println("TestExecutionException caught: " + e.getMessage());
        }
    }

    private boolean testExecutionFails() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AutomationSoftwareTester that = (AutomationSoftwareTester) o;
        return Objects.equals(super.getProjectDetails(), that.getProjectDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), super.getProjectDetails());
    }

    @Override
    public String toString() {
        return "AutomationSoftwareTester{" +
                "name='" + getName() + '\'' +
                ", employeeId=" + getEmployeeId() +
                ", projectA='" + super.getProjectDetails() + '\'' +
                '}';
    }
}
