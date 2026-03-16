package com.service;

import com.model.Person;
import com.exception.InvalidPersonException;

import java.util.List;

public class PersonService {

    List<Person> list;

    {
        list = registerPersons();
    }

    // counts persons in list
    public int countNumberOfPersons(List<Person> list){
        if(list == null){
            throw new RuntimeException("List cannot be null");
        }
        return list.size();
    }

    // validate person details
    public void validatePerson(Person person){

        if(person == null){
            throw new NullPointerException("Person ref cannot be null");
        }

        if(person.getName().length() < 2){
            throw new InvalidPersonException("Length must be greater than 1");
        }

        if(person.getAge() < 18){
            throw new InvalidPersonException("Age must be greater than 18");
        }
    }

    // register default persons
    public List<Person> registerPersons(){

        Person p1 = new Person(1,"harry",23,"london");
        Person p2 = new Person(2,"ronald",13,"surrey");
        Person p3 = new Person(3,"draco",24,"mumbai");

        return List.of(p1,p2,p3);
    }

    // return adults
    public List<Person> getAdultPersons(){
        return list.stream()
                .filter(person -> person.getAge() > 18)
                .toList();
    }
}