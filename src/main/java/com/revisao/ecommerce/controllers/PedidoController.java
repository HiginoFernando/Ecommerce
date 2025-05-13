package com.revisao.ecommerce.controllers;

import com.revisao.ecommerce.dto.ItemDoPedidoDTO;
import com.revisao.ecommerce.dto.PedidoDTO;
import com.revisao.ecommerce.entities.ItemDoPedido;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> createPedido(@RequestBody Pedido pedido) {
        Pedido saved = pedidoService.save(pedido);
        return ResponseEntity.status(201).body(toDTO(saved));
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAllPedidos() {
        List<PedidoDTO> pedidos = pedidoService.getAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable Long id) {
        return pedidoService.getById(id)
                .map(p -> ResponseEntity.ok(toDTO(p)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> updatePedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Optional<Pedido> existing = pedidoService.getById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Pedido toUpdate = existing.get();
        toUpdate.setMomento(pedido.getMomento());
        toUpdate.setPagamento(pedido.getPagamento());
        Pedido updated = pedidoService.save(toUpdate);
        return ResponseEntity.ok(toDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        if (pedidoService.getById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        pedidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Conversão de entidades para DTOs
    private PedidoDTO toDTO(Pedido p) {
        List<ItemDoPedidoDTO> itens = p.getItens().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());

        String status = null;
        if (p.getPagamento() != null && p.getPagamento().getStatus() != null) {
            status = p.getPagamento().getStatus().toString(); // evita usar .name()
        }

        return new PedidoDTO(
                p.getId(),
                p.getMomento(),
                p.getClienteId(),
                status,
                itens
        );
    }

    private ItemDoPedidoDTO toDTO(ItemDoPedido i) {
        return new ItemDoPedidoDTO(
                i.getId(),
                i.getProduto().getId(),
                i.getProduto().getNome(),
                i.getQuantidade(),
                i.getPreco()
        );
    }
}
