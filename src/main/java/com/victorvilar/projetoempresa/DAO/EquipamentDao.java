package com.victorvilar.projetoempresa.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.victorvilar.projetoempresa.model.Client;
import com.victorvilar.projetoempresa.model.Equipament;

/**
 * Class to manager Equipament in database
 * @since 2022-02-14
 * @author Victor Vilar
 */
@Deprecated
public class EquipamentDao {
    EntityManager em;

    public EquipamentDao(EntityManager em){
        this.em = em;

    }

    public void saveEquipament(Equipament equipament){
        this.em.getTransaction().begin();
        this.em.persist(equipament);
        this.em.getTransaction().commit();
    }

    public List<Equipament> getAllEquipaments(){
        String sql = "SELECT e From Equipament e";
        List<Equipament> equipaments = this.em.createQuery(sql,Equipament.class).getResultList();
        return equipaments;
    }

	public Equipament findEquipament(long l) {
		return this.em.find(Equipament.class, l);
	}

	public void updateEquipament(Equipament equipament) {
		this.em.getTransaction().begin();
		this.em.merge(equipament);
		this.em.getTransaction().commit();
		
	}
    
   





}
