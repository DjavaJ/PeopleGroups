package com.theironyard.novauc.controllers;

/**
 * Created by dangelojoyce on 3/29/17.
 */
public class PeterStuff {
    private String id;
    private String affiliation;
    private String name;
    private String address;
    private String emailaddress;
    private String flavor;


    public PeterStuff(String id, String affiliation, String name, String address, String emailaddress, String flavor) {
        this.id = id;
        this.affiliation = affiliation;
        this.name = name;
        this.address = address;
        this.emailaddress = emailaddress;
        this.flavor = flavor;
    }
}
