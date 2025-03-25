package com.revisao.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revisao.ecommerce.entities.ItemDoPedido;
import com.revisao.ecommerce.repositories.ItemDoPedidoRepository;

@Service
public class ItemDoPedidoService {

    @Autowired
    private ItemDoPedidoRepository itemDoPedidoRepository;

    public List<ItemDoPedido> findAll() {
        return itemDoPedidoRepository.findAll();
    }

    public Optional<ItemDoPedido> findById(Long id) {
        return itemDoPedidoRepository.findById(id);
    }

    public ItemDoPedido save(ItemDoPedido itemDoPedido) {
        return itemDoPedidoRepository.save(itemDoPedido);
    }

    public void delete(Long id) {
        itemDoPedidoRepository.deleteById(id);
    }
}
