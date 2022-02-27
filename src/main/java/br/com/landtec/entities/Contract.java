package br.com.landtec.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Class that represents the contract of a Client
 * @since 2022-02-14
 * @author Victor Vilar
 */
@Entity
@Table(name="contracts")
public class Contract {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String number;
    @Column(nullable=false)
    private LocalDate validity;
    
    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private List<ItemContract> itens;
    
	@ManyToOne
	private Client client;
	
	/**
	 * add a new item to contract, add this contract to item
	 * @param itemContract
	 */
	public void addNewItem(ItemContract itemContract) {
		itemContract.setContract(this);
		this.getItens().add(itemContract);
	}
	
    
    //Constructors
    public Contract() {
		
	}
    //-----------------------


  //getters and setters - number
	public String getNumber() {
		return number;
	}




	public void setNumber(String number) {
		this.number = number;
	}
	//-----------------------


	//getters and setters - validity
	public LocalDate getValidity() {
		return validity;
	}




	public void setValidity(LocalDate validity) {
		this.validity = validity;
	}
	//-----------------------


	//getters and setters - itens
	public List<ItemContract> getItens() {
		return itens;
	}

	public void setItens(List<ItemContract> itens) {
		this.itens = itens;
	}
	//-----------------------

	//getters e setters - client
	public void setClient(Client client2) {
		this.client = client2;
		
	}
	
	public Client getCliente() {
		return this.client;
	}
	//--------------
	

}
