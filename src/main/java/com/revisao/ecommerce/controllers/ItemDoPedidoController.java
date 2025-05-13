package com.revisao.ecommerce.controllers;

import com.revisao.ecommerce.entities.ItemDoPedido;
import com.revisao.ecommerce.services.ItemDoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itens-pedido")
public class ItemDoPedidoController {

    @Autowired
    private ItemDoPedidoService itemService;

    @PostMapping
    public ResponseEntity<ItemDoPedido> createItem(@RequestBody ItemDoPedido item) {
        ItemDoPedido saved = itemService.save(item);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public List<ItemDoPedido> getAllItems() {
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDoPedido> getItemById(@PathVariable Long id) {
        Optional<ItemDoPedido> itemOp = itemService.getById(id);
        return itemOp.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/pedido/{pedidoId}")
    public List<ItemDoPedido> getItemsByPedido(@PathVariable Long pedidoId) {
        return itemService.getByPedidoId(pedidoId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDoPedido> updateItem(
            @PathVariable Long id,
            @RequestBody ItemDoPedido item) {

        Optional<ItemDoPedido> existing = itemService.getById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        ItemDoPedido toUpdate = existing.get();
        toUpdate.setQuantidade(item.getQuantidade());
        toUpdate.setPreco(item.getPreco());
        toUpdate.setProduto(item.getProduto());
        toUpdate.setPedido(item.getPedido());
        ItemDoPedido updated = itemService.save(toUpdate);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (itemService.getById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        itemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
