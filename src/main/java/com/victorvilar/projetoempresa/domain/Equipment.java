package com.victorvilar.projetoempresa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A class that represents the equipments available for store the trash
 * @author Victor
 * @since 2022-02-21
 */
@Entity
@Table(name="equipments")
public class Equipment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="equipment",nullable = false)
	private String equipmentName;
	
	@Column(name="size_cubic",nullable = false)
	private double sizeInMeterCubic;

	
	//constructors
	public Equipment() {
		
	}
	//-----------
	
	
	//getters e setters - name
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	//-----------
	
	
	//getters e setters - size
	public double getSizeInMeterCubic() {
		return sizeInMeterCubic;
	}
	public void setSizeInMeterCubic(double sizeInMeterCubic) {
		this.sizeInMeterCubic = sizeInMeterCubic;
	}
	//-----------

	//getters e setters - id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	//-----------
}