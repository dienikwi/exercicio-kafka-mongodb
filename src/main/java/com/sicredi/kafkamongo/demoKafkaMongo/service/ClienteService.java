package com.sicredi.kafkamongo.demoKafkaMongo.service;

import com.sicredi.kafkamongo.demoKafkaMongo.dto.ClienteDTO;
import com.sicredi.kafkamongo.demoKafkaMongo.model.Cliente;
import com.sicredi.kafkamongo.demoKafkaMongo.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public Cliente cadastraCliente(ClienteDTO cliente) {
        Cliente clienteModel = null;

        if (cliente != null) {
            Optional<Cliente> aux = clienteRepository.findById(cliente.getCodCliente());
            if (aux != null) {
                throw new IllegalArgumentException("Cliente já cadastrado.");
            }
            clienteModel = new Cliente(cliente.getCodCliente(), cliente.getNomeCliente());
            clienteRepository.insert(clienteModel);
        }
        return clienteModel;
    }
}
