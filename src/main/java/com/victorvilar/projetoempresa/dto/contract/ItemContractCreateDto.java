package com.victorvilar.projetoempresa.dto.contract;


import com.victorvilar.projetoempresa.domain.CollectionFrequency;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ItemContractCreateDto {

    @NotNull(message = "The item must have a residue")
    private Long residue;

    @NotNull(message = "the item must have an equipment")
    private Long equipment;

    @NotNull(message="the item must have a quantity of equipment that going to be available")
    private Integer equipmentQuantity;

    @NotNull(message = "the item must have a quantity")
    private Double qtdOfResidue;

    @NotNull(message = "the item must have a value")
    private BigDecimal itemValue;

    private String description;

    @NotNull(message = "the item must have a frequency that the service going to be undertaken")
    private CollectionFrequency collectionFrequency;


    //constructors
    public ItemContractCreateDto() {

    }
    public ItemContractCreateDto(Long residue, Long equipment, Double qtdOfResidue, BigDecimal itemValue, String description) {
        this.residue = residue;
        this.equipment = equipment;
        this.qtdOfResidue = qtdOfResidue;
        this.itemValue = itemValue;
        this.description = description;
    }
    //----------------------------


    public Long getResidue() {
        return residue;
    }

    public void setResidue(Long residue) {
        this.residue = residue;
    }

    public Long getEquipment() {
        return equipment;
    }

    public void setEquipment(Long equipament) {
        this.equipment = equipament;
    }

    public Double getQtdOfResidue() {
        return qtdOfResidue;
    }

    public void setQtdOfResidue(Double qtdOfResidue) {
        this.qtdOfResidue = qtdOfResidue;
    }

    public BigDecimal getItemValue() {
        return itemValue;
    }

    public void setItemValue(BigDecimal itemValue) {
        this.itemValue = itemValue;
    }

    //getters and setters - description
    public String getDescription() {return this.description;}
    public void setDescription(String description){this.description = description;}
    //-----------

    //getters and setters - equipment quantity
    public Integer getEquipmentQuantity() {return this.equipmentQuantity;}
    public void setEquipmentQuantity(Integer equipmentQuantity){this.equipmentQuantity = equipmentQuantity;}
    //-----------

    //getters and setter - collection frequency
    public CollectionFrequency getCollectionFrequency(){ return this.collectionFrequency;}
    public void setCollectionFrequency(CollectionFrequency collectionFrequency){this.collectionFrequency = collectionFrequency;}
    //-----------

}
