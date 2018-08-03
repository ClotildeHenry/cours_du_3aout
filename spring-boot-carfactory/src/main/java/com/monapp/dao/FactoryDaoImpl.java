package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monapp.metier.Factory;


@Transactional
@Repository
public class FactoryDaoImpl implements FactoryDao{

	@PersistenceContext
	EntityManager em;


	@Override
	public List<Factory> findAll() {
		String querystring = "SELECT v FROM Factory v " ;
		Query query = em.createQuery( querystring ) ;
		List<Factory> list = query.getResultList() ;
		return list;
	}

	@Override
	public Factory save(Factory entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Factory entity) {
		entity = em.merge(entity);
		em.remove(entity);
		
	}

	public Factory findByPrimaryKey(Integer id) {
		return em.find(Factory.class, id);
	}

	@Override
	public Factory update(Factory entity) {
		em.merge(entity);
		return null;
	}
}
