package com.revisao.ecommerce.controllers;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revisao.ecommerce.dto.ProdutoDTO;
import com.revisao.ecommerce.services.ProdutoService;

@RestController
@RequestMapping
public class ProdutoController {

	@Autowired
	ProdutoService service;
	
	@GetMapping
	
	public List<ProdutoDTO>findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/pagina")
	public Page<ProdutoDTO> findAll(Pageable pagina){
		return service.findPagina((org.springframework.data.domain.Pageable) pagina);
	}
	

}
