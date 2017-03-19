package com.theironyard.novauc;

import javax.persistence.*;

/**
 * Created by dangelojoyce on 3/17/17.
 */
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String address;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String phonenumber;

    @Column (nullable = false)
    String ssn;

    public Person(){

    }

    public Person(String name, String address, String email, String phonenumber, String ssn){
        this.name = name;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
        this.ssn = ssn;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
