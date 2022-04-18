package ru.gov.pfr.sev.data;

import java.util.ArrayList;
import java.util.List;

public class Persons {
    private List<Person> listPerson;
//    private Integer id=1;
    public Persons() {
        this.listPerson = new ArrayList<>();
    }

    public void addPerson(Person person) {
//        person.setId(this.id);
        this.listPerson.add(person);
    }

    public List<Person> getPersons(){

        return this.listPerson;
    }
}
