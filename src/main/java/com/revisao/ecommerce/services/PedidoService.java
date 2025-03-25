package com.revisao.ecommerce.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.repositories.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido save(Pedido pedido) {
        if (pedido.getMomento() == null) {
            pedido.setMomento(Instant.now()); // Garante que o momento não seja nulo
        }
        return pedidoRepository.save(pedido);
    }

	public List<Pedido> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
