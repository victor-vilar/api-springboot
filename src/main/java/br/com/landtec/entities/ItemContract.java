package br.com.landtec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A class that represents the itens of contract
 * @author Victor
 * @since 2022-02-21
 */
@Entity
@Table(name = "itens-contract")
public class ItemContract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//the type of residue(trash) of the item.
	@ManyToOne
	@Column(nullable = false)
	private ResidueType residue;
	
	//the equipament that gonna be used to store the trash.
	@ManyToOne
	@Column(nullable = false)
	private Equipament equipament;
	
	//the quantity estimated for  year
	@Column(nullable = false, name="max_qtd_year")
	private Double qtdOfResidue;
	
	//the value of the item
	@Column(nullable=false)
	private double value;

	
	
	//getters e setters - residue
	public ResidueType getResidue() {
		return residue;
	}

	public void setResidue(ResidueType residue) {
		this.residue = residue;
	}
	//-----------
	
	//getters e setters - equipament
	public Equipament getEquipament() {
		return equipament;
	}

	public void setEquipament(Equipament equipament) {
		this.equipament = equipament;
	}
	//-----------
	
	//getters e setters - amount
	public Double getQtdOfResidue() {
		return qtdOfResidue;
	}

	public void setQtdOfResidue(Double qtdOfResidue) {
		this.qtdOfResidue = qtdOfResidue;
	}
	//-----------
	
	//getters e setters - value
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	//-----------
	
	
	
	
}