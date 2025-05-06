package com.revisao.ecommerce.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.entities.Pagamento;
import com.revisao.ecommerce.repositories.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    
    public Pedido save(Pedido pedido) {
       
        if (pedido.getMomento() == null) {
            pedido.setMomento(Instant.now());
        }

        if (pedido.getPagamento() != null) {
            Pagamento pagamento = pedido.getPagamento();
            if (pagamento.getMomento() == null) {
                pagamento.setMomento(Instant.now());
            }
            pagamento.setPedido(pedido);
        }
        return pedidoRepository.save(pedido);
    }

   
    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }


    public Optional<Pedido> getById(Long id) {
        return pedidoRepository.findById(id);
    }


    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }
}
