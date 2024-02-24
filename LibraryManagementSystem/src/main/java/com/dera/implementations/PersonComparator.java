package com.dera.implementations;

import com.dera.entities.Person;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2){
        if(p1.getRole().getPriority()>p2.getRole().getPriority()){
            return 1;
        } else if (p1.getRole().getPriority()<p2.getRole().getPriority()) {
            return -1;
        } else {
            return 0;
        }
    }
}
