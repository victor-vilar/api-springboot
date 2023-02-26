package com.victorvilar.projetoempresa.configuration;

import com.victorvilar.projetoempresa.controllers.dto.adress.AddressResponseDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ContractResponseDto;
import com.victorvilar.projetoempresa.controllers.dto.contract.ItemContractResponseDto;
import com.victorvilar.projetoempresa.controllers.dto.supervisor.SupervisorResponseDto;
import com.victorvilar.projetoempresa.domain.Address;
import com.victorvilar.projetoempresa.domain.Contract;
import com.victorvilar.projetoempresa.domain.ItemContract;
import com.victorvilar.projetoempresa.domain.Supervisor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(Supervisor.class, SupervisorResponseDto.class).
                addMappings(maper -> {
                    maper.map(src -> src.getCliente().getCpfCnpj(),SupervisorResponseDto::setCustomerId);
                });

        mapper.typeMap(Contract.class, ContractResponseDto.class)
                .addMappings(maper ->{
                    maper.map(src -> src.getCustomer().getCpfCnpj(), ContractResponseDto::setCustomerId);
                });

        mapper.typeMap(Address.class, AddressResponseDto.class)
                .addMappings(maper ->{
                    maper.map(src -> src.getClient().getCpfCnpj(), AddressResponseDto::setCustomerId);
                });

        mapper.typeMap(ItemContract.class, ItemContractResponseDto.class)
                .addMappings(maper ->{
                    maper.map(src-> src.getResidue().getType(), ItemContractResponseDto::setResidue);
                    maper.map(src-> src.getEquipament().getEquipmentName(),ItemContractResponseDto::setEquipment);
                });

        return mapper;
    }
}
