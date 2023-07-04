package com.victorvilar.projetoempresa.mappers;


import com.victorvilar.projetoempresa.controllers.dto.adress.AddressCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.adress.AddressResponseDto;
import com.victorvilar.projetoempresa.domain.customer.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class AddressMapper {

    private final ModelMapper mapper;

    @Autowired

    public AddressMapper(ModelMapper mapper){
        this.mapper = mapper;
    }

    public Address toAddress(AddressCreateDto addressCreateDto){
        return this.mapper.map(addressCreateDto,Address.class);
    }

    public AddressResponseDto toAddressResponseDto(Address address){
        return this.mapper.map(address,AddressResponseDto.class);
    }

    public List<AddressResponseDto> toAddressResponseDtoList( List<Address> addresses){
        return addresses.stream().map(
                e -> this.toAddressResponseDto(e)
        ).collect(Collectors.toList());
    }


}
