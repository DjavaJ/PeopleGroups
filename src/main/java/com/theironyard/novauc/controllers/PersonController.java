package com.theironyard.novauc.controllers;

import com.theironyard.novauc.Person;
import com.theironyard.novauc.entities.PersonRepositoryInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by dangelojoyce on 3/17/17.
 */
@RestController

public class  PersonController {
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

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        request.setAttribute("logout","logout");
        return "login";
    }

    @PostConstruct
    public void init() {
        if (persons.count() == 0) {
            Person person = new Person();
            person.setName("John");
            person.setAddress("123 NY Ave");
            person.setEmail("john@gmail.com");
            person.setPhonenumber("301-555-5555");
            person.setSsn("000-00-0000");
            persons.save(person);
        }
    }
}
