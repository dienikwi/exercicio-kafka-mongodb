package com.sicredi.kafkamongo.demoKafkaMongo.kafka;

import com.sicredi.kafkamongo.demoKafkaMongo.dto.PedidoDTO;
import com.sicredi.kafkamongo.demoKafkaMongo.model.Pedido;
import com.sicredi.kafkamongo.demoKafkaMongo.model.Produto;
import com.sicredi.kafkamongo.demoKafkaMongo.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PedidoJKConsumer {
    private PedidoRepository pedidoRepository;

    public void consomePedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido(pedidoDTO.getCodCliente(), pedidoDTO.getItens());
        pedidoRepository.insert(pedido);
    }
}
