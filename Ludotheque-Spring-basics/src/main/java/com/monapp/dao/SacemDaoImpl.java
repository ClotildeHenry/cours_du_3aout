package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monapp.metier.Sacem;

@Transactional
@Repository
public class SacemDaoImpl implements SacemDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Sacem> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Sacem> crit = cb.createQuery(Sacem.class);
		Root<Sacem> r = crit.from(Sacem.class);
		
		crit.select(r);
		
		return em.createQuery(crit).getResultList();
	}

	@Override
	public Sacem save(Sacem entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Sacem entity) {
		Sacem eMerged = em.merge(entity);
		em.remove(eMerged);
		
	}
	
	@Override
	public Sacem findByPrimaryKey(Integer id) {
		return em.find(Sacem.class, id);
	}

	@Override
	public Sacem update(Sacem entity) {
		return em.merge(entity);
	}



}
