package com.revisao.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revisao.ecommerce.dto.ItemDoPedidoDTO;
import com.revisao.ecommerce.entities.ItemDoPedido;
import com.revisao.ecommerce.entities.Pedido;
import com.revisao.ecommerce.entities.Produto;
import com.revisao.ecommerce.repositories.ItemDoPedidoRepository;
import com.revisao.ecommerce.repositories.PedidoRepository;
import com.revisao.ecommerce.repositories.ProdutoRepository;

@Service
public class ItemDoPedidoService {

    @Autowired
    private ItemDoPedidoRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<ItemDoPedido> findAll() {
        return repository.findAll();
    }

    public Optional<ItemDoPedido> findById(Long id) {
        return repository.findById(id);
    }

    public ItemDoPedido save(ItemDoPedido item) {
        return repository.save(item);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ItemDoPedido saveFromRequest(ItemDoPedidoDTO request) {
        ItemDoPedido item = new ItemDoPedido();
        item.setClienteId(request.getClienteId());
        item.setItens(request.getItens());
        item.setQuantidade(request.getQuantidade());
        item.setPreco(request.getPreco());

        Produto produto = produtoRepository.findById(request.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        item.setProduto(produto);

        // Exemplo: usa o primeiro pedido do banco para associar (substitua por lógica real)
        Pedido pedido = pedidoRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Nenhum pedido encontrado"));
        item.setPedido(pedido);

        return repository.save(item);
    }
}
