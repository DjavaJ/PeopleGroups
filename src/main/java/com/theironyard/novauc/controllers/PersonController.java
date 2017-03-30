package com.theironyard.novauc.controllers;

import com.theironyard.novauc.Person;
import com.theironyard.novauc.entities.PersonRepositoryInterFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @RequestMapping(path = "/WillUser/{id}", method = RequestMethod.GET)
    public WillStuff getWillUser(@PathVariable("id") int id) {
        RestTemplate restTemplate = new RestTemplate();
        WillStuff ws = restTemplate.getForObject("https://pure-lake-90830.herokuapp.com/user/" + id, WillStuff.class);

        return ws;
    }

    @RequestMapping(path = "/PeterUser/{id}", method = RequestMethod.POST)
    public void postPeterStuff(@PathVariable("id") int id) {

        WillStuff peter = getWillUser(id);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");

        headers.setAll(map);

        Map req_payload = new HashMap();
        req_payload.put("affiliation", peter.getServicebranch());
        req_payload.put("name", peter.getName());
        req_payload.put("address", peter.getAddress());
        req_payload.put("emailAddress", peter.getEmail());
        req_payload.put("id", peter.getId());
        req_payload.put("flavor", peter.getCellphone());


        HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
        String url = "https://immense-lowlands-84747.herokuapp.com/user";

        ResponseEntity<?> response = new RestTemplate().postForEntity(url, request, String.class);


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
