package com.victorvilar.projetoempresa.services;

import java.util.List;

import com.victorvilar.projetoempresa.controllers.dto.customer.CustomerCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.customer.CustomerResponseDto;
import com.victorvilar.projetoempresa.domain.customer.Customer;
import com.victorvilar.projetoempresa.exceptions.CustomerNotFoundException;
import com.victorvilar.projetoempresa.exceptions.CpfOrCnpjAlreadyExistsException;
import com.victorvilar.projetoempresa.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorvilar.projetoempresa.exceptions.InvalidCpfOrCnpjException;
import com.victorvilar.projetoempresa.repository.CustomerRepository;
import com.victorvilar.projetoempresa.util.CpfCnpjValidator;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

	
	private final CustomerRepository repository;
	private final CustomerMapper mapper;
	
	@Autowired
	public CustomerService(CustomerRepository repository, CustomerMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	/**
	 * get all clients, transform in a clientResponseDto list and return;
	 * @param
	 */
	public List<CustomerResponseDto> getAllCustomers() {
		return this.mapper.toCustomerResponseDtoList(this.repository.findAll());
	}
	/**
	 * Return a client with this id, or return null;
	 * @param id
	 * @return
	 */
	public Customer findCustomerById(String id) throws CustomerNotFoundException {
		return this.repository.findByCpfCnpj(id).orElseThrow(() ->new CustomerNotFoundException("This client doesn't exist"));
	}

	/**
	 * Return a customerResponseDto
	 * @param id
	 * @return
	 */
	public CustomerResponseDto getCustomerById(String id){
		Customer customer = this.findCustomerById(id);
		return this.mapper.toCustomerResponseDto(customer);
	}

	
	/**
	 * Sing in a new Client
	 * @param customerCreateDto, a client
	 */
	@Transactional
	public CustomerResponseDto addNewCustomer(CustomerCreateDto customerCreateDto) throws InvalidCpfOrCnpjException, CpfOrCnpjAlreadyExistsException {

		Customer customer = this.mapper.toCustomer(customerCreateDto);

		//check if customer has a name
		if(customer.getNameCompanyName() == null){
			throw new NullPointerException("The customer must have a name");
		}

		//check if customer has as cpfCnpj
		if(customer.getCpfCnpj() == null){
			throw new NullPointerException("The customer must have a cpf or cnpj");
		}

		//if client with this cpf or cpjs already exists, throws a new exception
		boolean isPresent = this.repository.findByCpfCnpj(customer.getCpfCnpj()).isPresent();
		if(isPresent){
			throw new CpfOrCnpjAlreadyExistsException("This Cpf/Cnpj already exists");
		}
		//if the cpf or cnpj is valid, it saves the client
		if(CpfCnpjValidator.checkIfIsValid(customer.getCpfCnpj())) {
			//upper case client name
			customer.setNameCompanyName(customer.getNameCompanyName().toUpperCase());
			return this.mapper.toCustomerResponseDto(this.repository.save(customer));
		}else {
			throw new InvalidCpfOrCnpjException("This CPF or CNPJ is Invalid");
		}

	}

	/**
	 * update client
	 * @param customerCreateDto
	 * @return
	 */
	public CustomerResponseDto updateCustomer(CustomerCreateDto customerCreateDto) {
		Customer customer = findCustomerById(customerCreateDto.getCpfCnpj());
		customer.setCpfCnpj(customerCreateDto.getCpfCnpj());
		customer.setNameCompanyName(customerCreateDto.getNameCompanyName());
		return this.mapper.toCustomerResponseDto(repository.save(customer));
	}


	/**
	 * Delete a client of the database
	 * @param id id of a client
	 */
	@Transactional
	public void deleteCustomerById(String id) {
		//if the id is not found will throw a exception
		findCustomerById(id);
		repository.deleteById(id);
	}


}
