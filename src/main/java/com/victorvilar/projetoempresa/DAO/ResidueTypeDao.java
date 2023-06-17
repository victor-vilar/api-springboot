package com.victorvilar.projetoempresa.DAO;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.victorvilar.projetoempresa.domain.ResidueType;

/**
 * Class to manager Residues in database
 * @since 2022-02-14
 * @author Victor Vilar
 */
@Deprecated
public class ResidueTypeDao {
    EntityManager em;

    public ResidueTypeDao(EntityManager em){
        this.em = em;

    }

    public void saveResidue(ResidueType residuo){
        this.em.getTransaction().begin();
        this.em.persist(residuo);
        this.em.getTransaction().commit();
    }

    public List<ResidueType> getAllResidues(){
        String sql = "SELECT r From ResidueType r";
        List<ResidueType> residues = this.em.createQuery(sql,ResidueType.class).getResultList();
        return residues;
    }

	public ResidueType findClient(long l) {
		return this.em.find(ResidueType.class, l);
	}

	public void updateClient(ResidueType residuo) {
		this.em.getTransaction().begin();
		this.em.merge(residuo);
		this.em.getTransaction().commit();
		
	}
    
   





}
