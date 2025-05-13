package com.revisao.ecommerce.entities;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusDoPedidoConverter
        implements AttributeConverter<StatusDoPedido, String> {

    @Override
    public String convertToDatabaseColumn(StatusDoPedido atributo) {
        return atributo != null ? atributo.name() : null;
    }

    @Override
    public StatusDoPedido convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return StatusDoPedido.AGUARDANDO_PAGAMENTO;
        }
        try {
            return StatusDoPedido.valueOf(dbData);
        } catch (IllegalArgumentException ex) {
            // Se vier algo inesperado, cai aqui:
            return StatusDoPedido.AGUARDANDO_PAGAMENTO;
        }
    }
}
