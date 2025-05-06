package com.revisao.ecommerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido saved = pedidoService.save(pedido);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.getById(id);
        return pedido.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Optional<Pedido> existing = pedidoService.getById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Pedido toUpdate = existing.get();
        toUpdate.setMomento(pedido.getMomento());
        toUpdate.setPagamento(pedido.getPagamento());
        Pedido updated = pedidoService.save(toUpdate);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        if (pedidoService.getById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        pedidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
