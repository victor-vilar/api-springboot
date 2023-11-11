package com.victorvilar.projetoempresa.dto.customer;

import com.victorvilar.projetoempresa.dto.adress.AddressResponseDto;
import com.victorvilar.projetoempresa.dto.contract.ContractResponseDto;
import com.victorvilar.projetoempresa.dto.serviceorder.ServiceOrderResponseDto;
import com.victorvilar.projetoempresa.dto.supervisor.SupervisorResponseDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Class created to not expose the models of the API
 */
public class CustomerResponseDto {


    private String nameCompanyName;
    private String cpfCnpj;
    private List<SupervisorResponseDto> supervisors = new ArrayList<SupervisorResponseDto>();
    private List<ContractResponseDto> contracts = new ArrayList<ContractResponseDto>();
    private List<AddressResponseDto> addresses = new ArrayList<AddressResponseDto>();
    private List<ServiceOrderResponseDto> serviceOrders = new ArrayList<>();

    public CustomerResponseDto(){

    }

    public CustomerResponseDto(String cpfCnpj, String nameCompanyName){
        this.cpfCnpj = cpfCnpj;
        this.nameCompanyName = nameCompanyName;
    }


    //getters and setters - NameCompanyName
    public String getNameCompanyName() {
        return nameCompanyName;
    }
    public void setNameCompanyName(String nameCompanyName) {
        this.nameCompanyName = nameCompanyName;
    }
    //-------------

    //getters and setters - cpfCnpj
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    //-------------

    //getters and setters - supervisors
    public List<SupervisorResponseDto> getSupervisors(){
        return this.supervisors;
    }
    public void setSupervisors(List<SupervisorResponseDto> supervisors){
        this.supervisors = supervisors;
    }
    //-------------

    //getters and setters - contratos
    public List<ContractResponseDto> getContracts() {
        return this.contracts;
    }
    public void setContracts(List<ContractResponseDto> contratos) {
        this.contracts = contratos;
    }
    //-----------

    //getters and setters - address
    public List<AddressResponseDto> getAddresses() {
        return addresses;
    }
    public void setAddresses(List<AddressResponseDto> address) {
        this.addresses = address;
    }
    //-----------

    //getters and setters - address
    public List<ServiceOrderResponseDto> getServiceOrders() {
        return serviceOrders;
    }
    public void setServiceOrders(List<ServiceOrderResponseDto> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
    //-----------
}
