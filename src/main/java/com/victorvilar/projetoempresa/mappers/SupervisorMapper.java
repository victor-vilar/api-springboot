package com.victorvilar.projetoempresa.mappers;

import com.victorvilar.projetoempresa.controllers.dto.supervisor.SupervisorCreateDto;
import com.victorvilar.projetoempresa.controllers.dto.supervisor.SupervisorResponseDto;
import com.victorvilar.projetoempresa.controllers.dto.supervisor.SupervisorUpdateDto;
import com.victorvilar.projetoempresa.domain.customer.Supervisor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SupervisorMapper {

    private final ModelMapper mapper;

    @Autowired
    public SupervisorMapper(ModelMapper mapper){
        this.mapper = mapper;
    }

    public Supervisor toSupervisor(SupervisorCreateDto supervisorCreateDto){
        return this.mapper.map(supervisorCreateDto, Supervisor.class);
    }

    public Supervisor toSupervisor(SupervisorUpdateDto supervisorUpdateDto){
        return this.mapper.map(supervisorUpdateDto, Supervisor.class);
    }

    public SupervisorResponseDto toSupervisorResponseDto(Supervisor supervisor){
        return this.mapper.map(supervisor,SupervisorResponseDto.class);
    }



    public List<SupervisorResponseDto> toSupervisorResponseDtoList(List<Supervisor> supervisors){
        return supervisors.stream().map(e -> toSupervisorResponseDto(e)).collect(Collectors.toList());
    }

}
