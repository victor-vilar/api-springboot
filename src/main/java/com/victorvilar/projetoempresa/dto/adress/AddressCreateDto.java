package com.victorvilar.projetoempresa.dto.adress;

import jakarta.validation.constraints.NotBlank;

public class AddressCreateDto {


    private String addressName;
    private String addressNumber;
    private String complement;
    private String zipCode;
    private String city;
    private String state;
    private boolean requiresCollection;
    @NotBlank(message="An address must have a customer")
    private String customerId;


    public AddressCreateDto() {

    }

    public AddressCreateDto(
                            String addressName,
                            String addressNumber,
                            String complement,
                            String zipCode,
                            String city,
                            String state,
                            boolean requiresCollection,
                            String customerId) {

        this.addressName = addressName;
        this.addressNumber = addressNumber;
        this.complement = complement;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.requiresCollection = requiresCollection;
        this.customerId = customerId;
    }


    //getters e setters - addressName
    public String getAddressName() {
        return addressName;
    }
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
    //--------------

    //getters e setters - addressNumber
    public String getAddressNumber() {
        return addressNumber;
    }
    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }
    //--------------

    //getters e setters - complement
    public String getComplement() {
        return complement;
    }
    public void setComplement(String complement) {
        this.complement = complement;
    }
    //--------------

    //getters e setters - requiredCollection
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    //--------------

    //getters e setters - city
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    //--------------

    //getters e setters - state
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    //--------------

    //getters e setters - requiredCollection
    public boolean isRequiresCollection() {
        return requiresCollection;
    }
    public void setRequiresCollection(boolean requiresCollection) {
        this.requiresCollection = requiresCollection;
    }
    //--------------

    //getters and setters - customerId
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    //--------------

    public static AddressCreateBuilder builder(){
        return new AddressCreateBuilder();
    }

    public static class AddressCreateBuilder{

        private String addressName;
        private String addressNumber;
        private String complement;
        private String zipCode;
        private String city;
        private String state;
        private boolean requiresCollection;
        private String customerId;

        public AddressCreateBuilder addressName(String addressName){
            this.addressName = addressName;
            return this;
        }

        public AddressCreateBuilder addressNumber(String addressNumber){
            this.addressNumber = addressNumber;
            return this;
        }

        public AddressCreateBuilder complement(String complement){
            this.complement = complement;
            return this;
        }

        public AddressCreateBuilder zipCode(String zipCode){
            this.zipCode = zipCode;
            return this;
        }

        public AddressCreateBuilder city(String city){
            this.city = city;
            return this;
        }

        public AddressCreateBuilder state(String state){
            this.state = state;
            return this;
        }

        public AddressCreateBuilder requiresCollection(boolean requiresCollection){
            this.requiresCollection = requiresCollection;
            return this;
        }

        public AddressCreateBuilder customerId(String customerId){
            this.customerId = customerId;
            return this;
        }

        public AddressCreateDto build(){
            AddressCreateDto address= new AddressCreateDto();
            address.setAddressName(this.addressName);
            address.setAddressNumber(this.addressNumber);
            address.setComplement(this.complement);
            address.setZipCode(this.zipCode);
            address.setCity(this.city);
            address.setState(this.state);
            address.setRequiresCollection(this.requiresCollection);
            address.setCustomerId(this.customerId);
            return address;
        }
    }


}
