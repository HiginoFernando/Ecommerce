// src/main/java/com/revisao/ecommerce/controllers/PagamentoController.java
package com.revisao.ecommerce.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.revisao.ecommerce.entities.Pagamento;
import com.revisao.ecommerce.services.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public Pagamento savePagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.save(pagamento);
    }

    @GetMapping
    public List<Pagamento> getAllPagamentos() {
        return pagamentoService.getAll();
    }
}
