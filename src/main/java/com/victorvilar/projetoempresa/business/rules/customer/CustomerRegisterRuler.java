package com.victorvilar.projetoempresa.business.rules.customer;

import com.victorvilar.projetoempresa.domain.Customer;
import com.victorvilar.projetoempresa.repository.CustomerRepository;

public interface CustomerRegisterRuler {

    public void verification(Customer customer , CustomerRepository repository);
}
