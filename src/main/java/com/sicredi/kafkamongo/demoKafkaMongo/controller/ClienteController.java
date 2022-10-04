package com.sicredi.kafkamongo.demoKafkaMongo.controller;

import com.sicredi.kafkamongo.demoKafkaMongo.dto.ClienteDTO;
import com.sicredi.kafkamongo.demoKafkaMongo.model.Cliente;
import com.sicredi.kafkamongo.demoKafkaMongo.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController
public class ClienteController {
    private ClienteService clienteService;

    @PostMapping("/cliente/add")
    public ResponseEntity<Void> cadastraCliente(@RequestBody ClienteDTO clienteDto) {
        Cliente cliente = clienteService.cadastraCliente(clienteDto);

        if (cliente == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(cliente.getCodCliente()).toUri();
        return  ResponseEntity.created(location).build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException excp){
        return ResponseEntity.
                status(HttpStatus.EXPECTATION_FAILED).
                body(excp.getMessage());
    }
}
