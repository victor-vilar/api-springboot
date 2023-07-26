package com.victorvilar.projetoempresa.dto.supervisor;

public class SupervisorResponseDto {

    private Long id;
    private String name;
    private String role;
    private String phoneNumber;
    private String email;
    private String clientId;


    //constructors
    public SupervisorResponseDto() {

    }
    //-----------

    //getters e setters - id
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
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

    //getters e setters - clientId
    public String getCustomerId() {
        return clientId;
    }
    public void setCustomerId(String clientId) {
        this.clientId = clientId;
    }
    //--------------

    public static SupervisorResponseDtoBuilder builder(){
        return new SupervisorResponseDtoBuilder();
    }
    
    public static class SupervisorResponseDtoBuilder {
        private Long id;
        private String name;
        private String role;
        private String phoneNumber;
        private String email;
        private String customerId;
        
        public SupervisorResponseDtoBuilder id(Long id){
            this.id = id;
            return this;
        }

        public SupervisorResponseDtoBuilder name(String name){
            this.name =name;
            return this;
        }

        public SupervisorResponseDtoBuilder role(String role){
            this.role = role;
            return this;
        }

        public SupervisorResponseDtoBuilder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public SupervisorResponseDtoBuilder email(String email){
            this.email = email;
            return this;
        }

        public SupervisorResponseDtoBuilder customerId(String customerId){
            this.customerId = customerId;
            return this;
        }

        public SupervisorResponseDto build(){
            SupervisorResponseDto supervisor = new SupervisorResponseDto();
            supervisor.setId(this.id);
            supervisor.setName(this.name);
            supervisor.setRole(this.role);
            supervisor.setPhoneNumber(this.phoneNumber);
            supervisor.setEmail(this.email);
            supervisor.setCustomerId(this.customerId);
            return supervisor;
        }
        
        
    }




}
