package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monapp.metier.Voiture;


@Transactional
@Repository
public class VoitureDaoImpl implements VoitureDao{

	@PersistenceContext
	EntityManager em;


	@Override
	public List<Voiture> findAll() {
		String querystring = "SELECT v FROM Voiture v " ;
		Query query = em.createQuery( querystring ) ;
		List<Voiture> list = query.getResultList() ;
		return list;
	}

	@Override
	public Voiture save(Voiture entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Voiture entity) {
		entity = em.merge(entity);
		em.remove(entity);
		
	}

	public Voiture findByPrimaryKey(Integer id) {
		return em.find(Voiture.class, id);
	}

	@Override
	public Voiture update(Voiture entity) {
		em.merge(entity);
		return null;
	}
}
