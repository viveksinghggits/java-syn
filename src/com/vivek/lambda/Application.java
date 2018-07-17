package com.vivek.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args){
        // init the collection
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("TechM", 26, 23));
        persons.add(new Person("SelfEmpl", 23, 27));
        persons.add(new Person("GOOGL", 27, 28));
        persons.add(new Person("NETFLX", 22, 29));
        persons.add(new Person("DROP", 21, 21));
        persons.add(new Person("APPL", 20, 22));

        printPersons(persons, o -> {
            Person p = (Person)o;
            return (p.getAge()<25);
        });


    }

    static void printPersons(List<Person> persons, Predicate p){// a predefined functional interface
        for(Person person: persons){
            if(p.test(person)){
                System.out.println(person.getCompName());
            }
        }
    }
}
