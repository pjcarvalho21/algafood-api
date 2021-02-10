package com.algaworks.algafood.api.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@RequestMapping(name = "estados")
@RestController
public class EstadoControlller {

	@Autowired
	private EstadoRepository estadoRepository;

	@GetMapping
	public List<Estado> estados() {
		return estadoRepository.listar();

	}

}
