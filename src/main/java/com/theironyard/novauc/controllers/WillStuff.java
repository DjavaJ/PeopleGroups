package com.theironyard.novauc.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by dangelojoyce on 3/29/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class WillStuff {
    private String address;
    private String cellphone;
    private String id;
    private String name;
    private String email;
    private String servicebranch;

    public WillStuff() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServicebranch() {
        return servicebranch;
    }

    public void setServicebranch(String servicebranch) {
        this.servicebranch = servicebranch;
    }
}



