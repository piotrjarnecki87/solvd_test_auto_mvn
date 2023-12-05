package com.solvd.course.hm.project.it.company.interfaces;

@FunctionalInterface
public interface Tester<T>  {
    void runTests(T tests);

}
