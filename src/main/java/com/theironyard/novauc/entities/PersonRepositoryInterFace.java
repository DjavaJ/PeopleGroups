package com.theironyard.novauc.entities;

import com.theironyard.novauc.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dangelojoyce on 3/17/17.
 */
public interface PersonRepositoryInterFace extends CrudRepository<Person, Integer> {
}
