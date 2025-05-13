package com.revisao.ecommerce.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

public class PedidoDTO implements Serializable {
    private Long id;
    private Instant momento;
    private Long usuarioId;
    private String status;       // continua String
    private List<ItemDoPedidoDTO> itens;

    public PedidoDTO() {}

    public PedidoDTO(Long id, Instant momento, Long usuarioId, String status, List<ItemDoPedidoDTO> itens) {
        this.id = id;
        this.momento = momento;
        this.usuarioId = usuarioId;
        this.status = status;
        this.itens = itens;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ItemDoPedidoDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemDoPedidoDTO> itens) {
		this.itens = itens;
	}


}
