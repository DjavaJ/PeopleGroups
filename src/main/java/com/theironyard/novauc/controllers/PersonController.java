package com.theironyard.novauc.controllers;

import com.theironyard.novauc.Person;
import com.theironyard.novauc.entities.PersonRepositoryInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dangelojoyce on 3/17/17.
 */
@RestController
public class PersonController {
    @Autowired
    PersonRepositoryInterFace persons;

    @Autowired

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<Person> getUsers() {
        return (List<Person>) persons.findAll();
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public void addUser(@RequestBody Person person) {
        persons.save(person);
    }

    @RequestMapping(path = "/user", method = RequestMethod.PUT)
    public void updateUser(@RequestBody Person person) {
        persons.save(person);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") int id) {
        persons.delete(id);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public Person getUser(@PathVariable("id") int id) {
        return persons.findOne(id);
    }
}