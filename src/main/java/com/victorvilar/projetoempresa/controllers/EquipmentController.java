package com.victorvilar.projetoempresa.controllers;

import com.victorvilar.projetoempresa.controllers.dto.equipament.EquipmentResponseDto;
import com.victorvilar.projetoempresa.domain.Equipment;
import com.victorvilar.projetoempresa.mappers.EquipmentMapper;
import com.victorvilar.projetoempresa.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;
    private final EquipmentMapper mapper;

    @Autowired
    public EquipmentController(EquipmentService equipmentService, EquipmentMapper mapper){
        this.equipmentService = equipmentService;
        this.mapper = mapper;
    }

    /**
     * get all equipments
     * @return a list of equiapments
     */
    @GetMapping("")
    public ResponseEntity<List<EquipmentResponseDto>> getAllEquipments(){
        return new ResponseEntity<List<EquipmentResponseDto>>(
                this.mapper.toEquipmentResponseDtoList(
                this.equipmentService.getAllEquipments()), HttpStatus.OK);
    }

    /**
     * get equipmant by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<EquipmentResponseDto> getEquipmentById(@PathVariable Long id){
        return new ResponseEntity<EquipmentResponseDto>(
                this.mapper.toEquipmentResponseDto(
                this.equipmentService.findEquipmentById(id)),HttpStatus.OK);
    }

    /**
     * save a new equipament
     * @param equipment equipament to save
     */
    @PostMapping("")
    public ResponseEntity<?> saveEquipment(@RequestBody Equipment equipment){
        System.out.println(equipment);
        this.equipmentService.saveEquipment(equipment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * update a equipament
     * @param equipment equipament instace to get the new data
     * @param id id of equipament to update
     * @return equipament updated
     */
    @PutMapping("/{id}")
    public ResponseEntity<Equipment> updateEquipment(@RequestBody Equipment equipment, @PathVariable Long id){
        return new ResponseEntity<Equipment>(this.equipmentService.updateEquipment(equipment,id),HttpStatus.OK);
    }

    /**
     * delete a equipament
     * @param id id to update
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEquipment(@PathVariable Long id){
        this.equipmentService.deleteEquipment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}