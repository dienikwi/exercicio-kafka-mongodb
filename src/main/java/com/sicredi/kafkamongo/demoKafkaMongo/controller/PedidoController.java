package com.sicredi.kafkamongo.demoKafkaMongo.controller;
import com.sicredi.kafkamongo.demoKafkaMongo.dto.PedidoDTO;
import com.sicredi.kafkamongo.demoKafkaMongo.dto.ProdutoDTO;
import com.sicredi.kafkamongo.demoKafkaMongo.model.Produto;
import com.sicredi.kafkamongo.demoKafkaMongo.service.PedidoProducerService;
import com.sicredi.kafkamongo.demoKafkaMongo.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class PedidoController {
    private PedidoProducerService pedidoProducerService;

    @PostMapping("/pedido/add")
    public ResponseEntity<String> cadastraPedido(@RequestBody PedidoDTO pedidoDTO) {
        pedidoProducerService.enviaPedido(pedidoDTO);
        return ResponseEntity.ok("Pedido criado!");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException excp){
        return ResponseEntity.
                status(HttpStatus.EXPECTATION_FAILED).
                body(excp.getMessage());
    }
}
