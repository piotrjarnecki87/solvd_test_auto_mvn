package com.solvd.course.hm.project.it.company.lists;

import com.solvd.course.hm.project.it.company.CEO;
import com.solvd.course.hm.project.it.company.Person;
import com.solvd.course.hm.project.it.company.enums.OrganisationRole;

import java.util.ArrayList;
import java.util.List;

public class StakeholderList {
    public static List<CEO> getCeoList() {
        List<CEO> ceos = new ArrayList<>();

    ceos.add(new CEO("Frank", 100, OrganisationRole.CEO));

return ceos;
    }
}
