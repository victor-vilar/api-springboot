package com.victorvilar.projetoempresa.services;

import com.victorvilar.projetoempresa.dto.equipment.EquipmentCreateDto;
import com.victorvilar.projetoempresa.dto.equipment.EquipmentResponseDto;
import com.victorvilar.projetoempresa.dto.equipment.EquipmentUpdateDto;
import com.victorvilar.projetoempresa.domain.Equipment;
import com.victorvilar.projetoempresa.exceptions.EquipmentNotFoundException;
import com.victorvilar.projetoempresa.mappers.EquipmentMapper;
import com.victorvilar.projetoempresa.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    @Autowired
    public EquipmentService(
            EquipmentRepository equipmentRepository,
            EquipmentMapper equipmentMapper){
        this.equipmentRepository = equipmentRepository;
        this.equipmentMapper = equipmentMapper;
    }

    /**
     * get all equipments
     * @return a list of equipments
     */
    public List<EquipmentResponseDto> getAll(){
        return this.equipmentMapper.toEquipmentResponseDtoList(this.equipmentRepository.findAll());
    }

    /**
     * get equipment by id
     * @param id id of a equipment
     * @return EquipmentResponseDto
     */

    public EquipmentResponseDto getById(Long id){
        return this.equipmentMapper.toEquipmentResponseDto(
                this.equipmentRepository.findById(id)
                        .orElseThrow(() -> new EquipmentNotFoundException("Equipment not found !"))
        );
    }

    /**
     * get equipment by id
     * @param id id of a equipment
     * @return equipment
     */
    public Equipment findEquipmentById(Long id){
                return this.equipmentRepository.findById(id)
                .orElseThrow(() -> new EquipmentNotFoundException("Equipment not found !"));
    }

    /**
     * save a new equipment
     * @param equipmentCreateDto equipment to save
     */
    @Transactional
    public EquipmentResponseDto save(EquipmentCreateDto equipmentCreateDto){
        Equipment equipment = this.equipmentMapper.toEquipament(equipmentCreateDto);
        return this.equipmentMapper.toEquipmentResponseDto(this.equipmentRepository.save(equipment));
    }

    /**
     * update an equipment
     * @param equipmentUpdateDto equipment instance to get the new data
     * @return equipment updated
     */
    public EquipmentResponseDto update(EquipmentUpdateDto equipmentUpdateDto){
        Equipment equipment = this.findEquipmentById(equipmentUpdateDto.getId());
        equipment.setEquipmentName(equipmentUpdateDto.getEquipmentName());
        equipment.setSizeInMeterCubic(equipmentUpdateDto.getSizeInMeterCubic());
        this.equipmentRepository.save(equipment);
        return this.equipmentMapper.toEquipmentResponseDto(equipment);

    }

    /**
     * delete a equipment
     * @param id id to update
     */
    @Transactional
    public void delete(Long id){
        this.equipmentRepository.delete(this.findEquipmentById(id));
    }



}
