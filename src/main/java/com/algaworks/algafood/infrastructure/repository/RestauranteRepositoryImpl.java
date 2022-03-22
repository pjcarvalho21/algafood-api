package com.algaworks.algafood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepositoryQueries;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> find(String nome, 
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		
		var jpql = new StringBuilder();
		    jpql.append("from Restaurante where 0 = 0");
		    
		    if(StringUtils.hasLength(nome)) {
		    	jpql.append(" and nome like :nome");
		    }
		    
		    if(taxaFreteInicial != null) {
		    	jpql.append(" and taxaFrete >= :taxaInicial ");
		    	
		    }
		    
		    if(taxaFreteFinal != null) {
		    	jpql.append(" and taxaFrete <= :taxaFinal");
		    	
		    }
		
		return manager.createQuery(jpql.toString(), Restaurante.class)
				.setParameter("nome", "%" + nome + "%")
				.setParameter("taxaInicial", taxaFreteInicial)
				.setParameter("taxaFinal", taxaFreteFinal)
				.getResultList();
	}
	
}
