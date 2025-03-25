package com.revisao.ecommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revisao.ecommerce.entities.Pagamento;
import com.revisao.ecommerce.services.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public List<Pagamento> findAll() {
        return pagamentoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pagamento> findById(@PathVariable Long id) {
        return pagamentoService.findById(id);
    }

    @PostMapping
    public Pagamento save(@RequestBody Pagamento pagamento) {
        return pagamentoService.save(pagamento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pagamentoService.delete(id);
    }
}
