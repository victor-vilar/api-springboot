package com.victorvilar.projetoempresa.controllers.dto.supervisor;

import com.victorvilar.projetoempresa.domain.Supervisor;

import javax.validation.constraints.NotBlank;

public class SupervisorCreateDto {



    private Long id;
    @NotBlank(message = "The name of supervisor is required")
    private String name;
    private String role;
    @NotBlank(message = "The phonenumer of supervisor is required")
    private String phoneNumber;
    private String email;
    private String clientId;

    //constructors
    public SupervisorCreateDto() {
    }
    //-----------

    //getters e setters - clientId
    public String getClientId() {
        return clientId;
    }
    public void setclientId(String id) {
        this.clientId = id;
    }
    //-----------

    //getters e setters - name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //-----------

    //getters e setters - role
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    //-------------

    //getters e setters = phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //--------------

    //getters e setters - email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //--------------



}
