package com.revisao.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revisao.ecommerce.entities.ItemDoPedido;

@Repository
public interface ItemDoPedidoRepository extends JpaRepository<ItemDoPedido, Long> {
    List<ItemDoPedido> findByPedidoId(Long pedidoId);
}
