package com.vivek.lambda;

public class Person {
    String compName;
    int age;
    int sal;

    public Person(String compName, int age, int sal) {
        this.compName = compName;
        this.age = age;
        this.sal = sal;
    }

    public String getCompName() {
        return compName;
    }

    public int getAge() {
        return age;
    }

    public int getSal() {
        return sal;
    }
}
