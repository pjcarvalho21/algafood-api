package com.algaworks.algafood.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;

import com.algaworks.algafood.domain.model.Cozinha;

public class CozinhaRepositoryImpl implements CozinhaRepository{
	
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Cozinha> listar() {
		return manager.createNamedQuery("from Cozinha", Cozinha.class).getResultList();
	}



	@Override
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}



	@Override
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}



	@Override
	@Transactional
	public void remover(Long id) {
		Cozinha cozinha = buscar(id);
		if(cozinha == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(cozinha);
	}
	

}
