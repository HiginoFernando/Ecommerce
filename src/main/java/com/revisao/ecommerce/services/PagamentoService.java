// src/main/java/com/revisao/ecommerce/services/PagamentoService.java
package com.revisao.ecommerce.services;

import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revisao.ecommerce.entities.Pagamento;
import com.revisao.ecommerce.repositories.PagamentoRepository;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento save(Pagamento pagamento) {
        if (pagamento.getMomento() == null) {
            pagamento.setMomento(Instant.now());
        }
        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> getAll() {
        return pagamentoRepository.findAll();
    }
}
