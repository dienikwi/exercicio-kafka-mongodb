package com.sicredi.kafkamongo.demoKafkaMongo.kafka;

import com.sicredi.kafkamongo.demoKafkaMongo.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class PedidoJKProducer {
    @Value("${spring.kafka.pedido-topico.name}")
    private String pedidoTopico;
    private KafkaTemplate<String, PedidoDTO> pedidoTemplate;

    public PedidoJKProducer(KafkaTemplate<String, PedidoDTO> template) {
        this.pedidoTemplate = template;
    }

    public void enviaPedido(PedidoDTO pedidoDTO) {
        Message<PedidoDTO> msg = MessageBuilder.withPayload(pedidoDTO).setHeader(KafkaHeaders.TOPIC, pedidoTemplate).build();

        pedidoTemplate.send(msg);
    }
}
