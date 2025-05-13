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
    private ItemDoPedidoRepository repository;

    /**
     * Salva um novo ItemDoPedido (ou atualiza se já existir).
     */
    public ItemDoPedido save(ItemDoPedido item) {
        return repository.save(item);
    }

    /**
     * Retorna todos os itens.
     */
    public List<ItemDoPedido> getAll() {
        return repository.findAll();
    }

    /**
     * Busca um item pelo seu ID.
     */
    public Optional<ItemDoPedido> getById(Long id) {
        return repository.findById(id);
    }

    /**
     * Retorna todos os itens associados a um determinado pedido.
     */
    public List<ItemDoPedido> getByPedidoId(Long pedidoId) {
        return repository.findByPedidoId(pedidoId);
    }

    /**
     * Deleta um item pelo seu ID.
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    /**
     * Deleta todos os itens de um pedido (útil ao remover um pedido).
     */
    public void deleteByPedidoId(Long pedidoId) {
        List<ItemDoPedido> itens = repository.findByPedidoId(pedidoId);
        repository.deleteAll(itens);
    }
}
