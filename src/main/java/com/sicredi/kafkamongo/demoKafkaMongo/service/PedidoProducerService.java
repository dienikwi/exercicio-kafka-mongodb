package com.sicredi.kafkamongo.demoKafkaMongo.service;
import com.sicredi.kafkamongo.demoKafkaMongo.dto.PedidoDTO;
import com.sicredi.kafkamongo.demoKafkaMongo.kafka.PedidoJKProducer;
import com.sicredi.kafkamongo.demoKafkaMongo.model.Cliente;
import com.sicredi.kafkamongo.demoKafkaMongo.model.Produto;
import com.sicredi.kafkamongo.demoKafkaMongo.repository.ClienteRepository;
import com.sicredi.kafkamongo.demoKafkaMongo.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PedidoProducerService {
    private PedidoJKProducer pedidoJKProducer;
    private ClienteRepository clienteRepository;
    private ProdutoRepository produtoRepository;

    public void enviaPedido(PedidoDTO pedidoDTO) {
        Optional<Cliente> cliente = null;
        Optional<Produto> produto = null;

        if (pedidoDTO == null) {
            throw new IllegalArgumentException("Pedido inválido.");
        }
        cliente = clienteRepository.findById(pedidoDTO.getCodCliente());
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente inválido no pedido.");
        }

        for (String aux: pedidoDTO.getItens()) {
            produto = produtoRepository.findById(aux);
            if (produto == null){
                throw new IllegalArgumentException("Item inválido.");
            }
        }

        pedidoJKProducer.enviaPedido(pedidoDTO);
    }
}
