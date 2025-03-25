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

import com.revisao.ecommerce.entities.ItemDoPedido;
import com.revisao.ecommerce.services.ItemDoPedidoService;

@RestController
@RequestMapping("/itens-do-pedido")
public class ItemDoPedidoController {

    @Autowired
    private ItemDoPedidoService itemDoPedidoService;

    @GetMapping
    public List<ItemDoPedido> findAll() {
        return itemDoPedidoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ItemDoPedido> findById(@PathVariable Long id) {
        return itemDoPedidoService.findById(id);
    }

    @PostMapping
    public ItemDoPedido save(@RequestBody ItemDoPedido itemDoPedido) {
        return itemDoPedidoService.save(itemDoPedido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        itemDoPedidoService.delete(id);
    }
}
